import requests

def download_file(file):
	res = requests.get(f"https://suanki-s3.s3.ap-south-1.amazonaws.com/{file}.csv")
	return res