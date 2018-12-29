import  re

def  checkPCorMobile(info):
    phoneheads=["iPhone","android","windowphone"]

    for data in phoneheads:
        print(data)
        val=re.search(data,info)
        print("----------",val)
        if val is None:
             return "PC"
        else:
             return  "Mobile"




