from lambda_function import lambda_handler
 
res = lambda_handler(None, None)
print(res)

#cd extralib
# zip -r ../project.zip .
#cd ..
#zip -g project.zip download.py lambda_function.py
#and upload this zip to lambda console and will be able to run
