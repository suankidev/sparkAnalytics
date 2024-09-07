import requests
import env
def download_file(file):
	res = requests.get(f"{env.s3_bucket_url}/{file}")
	return res