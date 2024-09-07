import os

s3_bucket_url=os.environ.get("AWS_BUCKET_NAME")
s3_bucket_name=os.environ.get("BUCKET_NAME")
source_file="taxi_zones.csv"
target_file="boto_copy_taxi_zones.csv"