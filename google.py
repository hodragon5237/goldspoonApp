from google_images_download import google_images_download   #importing the library

response = google_images_download.googleimagesdownload()   #class instantiation

arguments = {"keywords":"슈퍼주니어 최시원,이서진,싸이,차인표,로이킴,백종원,강동원,김준현,고윤,조세호,은지원,조재현,알리,고창석,윤태영,김영광,장동민,아이유,배용준,가수 도끼,유재석,정우성,원빈","limit":50,"print_urls":True}   #creating list of arguments
paths = response.download(arguments)   #passing the arguments to the function
print(paths)   #printing absolute paths of the downloaded images