import json
import download 

from upload import upload_s3
import env





def lambda_handler(event, context):
    # TODO implement
    download_res=download.download_file(env.source_file)
    upload_res=upload_s3(bucket=env.s3_bucket_name,
                         file=env.target_file,
                         body=download_res.content)
    return {
        'statusCode': download_res.status_code,
        'body': json.dumps('Hello from Lambda using gha downloader!')
    }