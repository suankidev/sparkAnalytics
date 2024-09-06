import json
import download 
def lambda_handler(event, context):
    # TODO implement
    download_res=download.download_file("taxi_zones")
    return {
        'statusCode': download_res.status_code,
        'body': json.dumps('Hello from Lambda using gha downloader!')
    }