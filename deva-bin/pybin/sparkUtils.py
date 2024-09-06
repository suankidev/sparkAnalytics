import boto3


s3_client=boto3.client("s3")

lst=s3_client.list_buckets()['Buckets']

print(lst)