import  tornado.web
import tornado.ioloop
import suds
import json
from  suds import  client
from  phonetutils.phone import *
from phonetutils.cacheutils import CacheService
class IndexHandler(tornado.web.RequestHandler):
    #get请求  self：当前对象
    def get(self):
        print("接受用户的get请求")
        #写一个消息
        # self.write("你好 java面向对象")
        self.render("login.html",failmsg=None)


class UserHandler(tornado.web.RequestHandler):
    def post(self):
        print("接受到用户的user_*请求")

        method=self.get_argument("action")
        print("method--->",method)

        if method=="login":

            username=self.get_argument("username")
            userpwd=self.get_argument("userpwd")
            print(username,userpwd)

            url="http://127.0.0.1:8070/userdataservice/user?wsdl"
            service=suds.client.Client(url)
            msg=service.service.checkUserLogin(username,userpwd)
            print("msg--->",msg)

            #怎么来区分是浏览器还是请求手机请求
            #得到请求的头
            headsInfo=self.request.headers

            #print("headsInfo-->",headsInfo)
            hinfo=headsInfo["User-Agent"]
            print("请求的头的信息是：",hinfo)
            val=checkPCorMobile(hinfo)
            print("val----->",val)


            jsonDatas=""
            if msg=="登录成功":
                #菜单数据不是经常变化的，我们应从缓存中获取，不应每次从数据库中响应
                #减少对数据库服务器的负载
                #方法一  每响应一次就要从数据库加载一次，增加服务器压力
                '''url = "http://127.0.0.1:8060/userdataservice/user?wsdl"
                service = suds.client.Client(url)
                data=service.service.queryGirdMenuData()
                print("data--->",data)
                print(type(data))
                jsonDatas=json.loads(data)
                print("jsonDatas-->",jsonDatas)'''

                #方法二 从缓存中获取数据 内部缓存
                cacheService=CacheService()
                jsonDatas = cacheService.getMenuData("tmenudata")

                print(jsonDatas)

                if val=="PC":
                    self.render("index.html",contentdata=jsonDatas)
                else:
                    #json数据格式
                    self.finish({"msg": "success", "contentdata": jsonDatas})
            else:
                if val=="PC":
                    self.render("login.html",failmsg=msg)
                else:
                    self.finish({"msg":"fail"})

        elif method=="register.html" :
            self.render("register.html")

class AntvHandler(tornado.web.RequestHandler):
    def post(self):
        print("Antv业务报表功能")
        method=self.get_argument("datas")
        print("method--->",method)
        if method=="classestostucount":
            url="http://127.0.0.1:8070/userdataservice/user?wsdl"

            service=suds.client.Client(url)

            data=service.service.queryClassToStuCount()

            print("data---***>",data)

            print(type(data))

            jsonDatas=json.loads(data)

            print("jsonDatas--!!!!!>",jsonDatas)

            self.finish({"jsonDatas":jsonDatas})

        elif method=="querynamecount":
            url="http://127.0.0.1:8070/userdataservice/user?wsdl"
            service=suds.client.Client(url)

            data=service.service.queryNameCount()

            print("data---***>",data)

            print(type(data))

            jsonDatas = json.loads(data)

            print("namecountData--****>",jsonDatas)

            self.finish({"namecountData":jsonDatas})









#设置配置项
settings={
    "template_path":"templates",
     "static_path":"static",
    }

#创建一个应用对象
#包含路由
app=tornado.web.Application([(r'/',IndexHandler),
                             (r'/user',UserHandler),
                             (r'/antv',AntvHandler),
                             ],**settings)



if __name__=="__main__":

    #绑定一个端口，和内网穿透一致
    app.listen(8060)
    #启动web程序，开始运行
    tornado.ioloop.IOLoop.current().start()

