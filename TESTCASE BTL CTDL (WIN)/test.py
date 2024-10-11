import subprocess
import time
import sys
import subprocess


# Set the encoding to UTF-8 to avoid UnicodeEncodeError
sys.stdout.reconfigure(encoding='utf-8')

print('-------------------------------------------')
# Tạo danh sách các file cần biên dịch
files = ["Main.java"]
subprocess.run(["javac"] + files)
j=0
# Biên dịch từng file và ghi tốc độ biên dịch vào file dotocdo.txt
with open("dotocdo.txt", "w", encoding='utf-8') as dotocdo_file:
    
    for i in range(7):

        # Tạo danh sách các file Main để chạy
        files_to_run = ["Main"]

        for file_to_run in files_to_run:
            # Chạy file Main bằng lệnh java
            start_time = time.time()
            subprocess.run(["java", file_to_run, str(i+1)])  
            end_time = time.time()

            # Tính và in tốc độ chạy java ra màn hình
            runtime = end_time - start_time
            if file_to_run == "Main":
                j += 1
                requirement = f"Req{j}"
                print(f"Tốc độ chạy java của {requirement}: {runtime} giây")

            # Ghi tốc độ chạy java vào file dotocdo.txt
            dotocdo_file.write(f"{runtime}\n")
            print("HOÀN THÀNH, KHÔNG GẶP LỖI!\n")

print('\nTiến Hành ghi lại chênh lệnh')
print('-------------------------------------------')
print('file luutocdo là file lưu lại tốc độ của tôi\n')
print('file dotocdo là file lưu lại tốc độ của bạn\n')
print('tốc độ chênh lệch = luutocdo - dotocdo\n')
print('Tiến Hành ghi lại tốc độ chạy java của các file requirement vào file luutocdo.txt\n')
print('tốc độ chênh lệch lần lượt:\n')

#So sánh các số trong dotocdo.txt với luutocdo.txt
with open("dotocdo.txt", "r", encoding='utf-8') as dotocdo_file, open("luutocdo.txt", "r", encoding='utf-8') as temptocdo_file, open("chenhlech.txt", "w", encoding='utf-8') as chenhlech_file:
    dotocdo_content = dotocdo_file.readlines()
    temptocdo_content = temptocdo_file.readlines()

    chenhlech_file.write("Số chênh lệch:\n")

    for i in range(min(len(dotocdo_content), len(temptocdo_content))):
        dotocdo_number = float(dotocdo_content[i].strip())
        temptocdo_number = float(temptocdo_content[i].strip())

        chenhlech = abs(dotocdo_number - temptocdo_number)
        requirement = f"Req{i+1}"
        chenhlech_file.write(f"{requirement}: {chenhlech}\n")
        print(f"{requirement}: {chenhlech}")  

print('-------------------------------------------')
print('Tiến Hành so sánh các file output, với test là file mẫu, requirement là file outp của bạn\n')

# Tạo danh sách các cặp tệp văn bản cần so sánh
file_pairs = [("Req1.txt", "test1.txt"), ("Req2.txt", "test2.txt"), ("Req3.txt", "test3.txt"), ("Req4.txt", "test4.txt"), ("Req5.txt", "test5.txt"), 
              ("Req6.txt", "test6.txt"), ("Req7.txt", "test7.txt") 
              ]

# Duyệt qua các cặp tệp văn bản và kiểm tra xem chúng có khớp nhau hay không
num_matches = 0
for file_pair in file_pairs:
    file1_path, file2_path = file_pair
    print(f"Đang so sánh {file1_path} và {file2_path}...")

    try:
        with open(file1_path, 'r', encoding='utf-8') as file1, open(file2_path, 'r', encoding='utf-8') as file2:
            file1_content = file1.read()
            file2_content = file2.read()

            # So sánh từng chữ hoặc từng kí tự của hai tệp văn bản
            if file1_content == file2_content:
                num_matches += 1
                print(f"{file1_path} và {file2_path} khớp nhau!")
            else:
                print(f"{file1_path} và {file2_path} không khớp nhau!")
    except FileNotFoundError:
        print(f"{file1_path} hoặc {file2_path} không tồn tại!")
    
    print()  
print('\nkiểm tra % trùng khớp \n')
print('\nkiểm tra % trùnng khớp \n')

if num_matches == len(file_pairs):
    print("100% trùng khớp dữ liệu từ test và requirement \n CHÚC MỪNG BẠN ĐÃ HOÀN THÀNH BÀI TẬP LỚN NÀY")
    print('-------------------------------------------')
    
