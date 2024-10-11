import pandas as pd
import numpy as np

# Tạo DataFrame từ dữ liệu đã cho
data = {
    'STT': list(range(1, 66)),
    'Giới tính': ['W', 'M', 'M', 'W', 'M', 'M', 'W', 'M', 'M', 'W', 'M', 'W', 'M', 'W', 'M', 'M', 'M', 'W', 'M', 'M', 'M', 'W', 'W', 'W', 'M', 'M', 'W', 'M', 'M', 'W', 'M', 'M', 'W', 'W', 'M', 'M', 'W', 'M', 'M', 'M', 'W', 'W', 'W', 'W', 'M', 'M', 'W', 'M', 'M', 'M', 'W', 'W', 'W', 'M', 'M', 'M', 'W', 'W', 'W', 'M', 'M', 'M', 'W', 'W', 'M'],
    'Tiền lương': [27, 61, 52, 69, 88, 85, 79, 99, 77, 165, 41, 83, 144, 74, 143, 131, 34, 59, 46, 105, 61, 118, 114, 138, 24, 67, 130, 56, 99, 125, 87, 30, 119, 40, 25, 44, 123, 45, 25, 94, 86, 128, 69, 102, 91, 106, 119, 139, 67, 47, 62, 92, 124, 31, 49, 68, 109, 138, 105, 84, 86, 66, 128, 146, 59]
}
df = pd.DataFrame(data)

# Tính lương sau 10 năm
df['Tiền lương sau 10 năm'] = df['Tiền lương'] * (1.2 ** 10)

# Tính giá trị trung bình, phương sai và độ lệch chuẩn
mean_initial = df['Tiền lương'].mean()
var_initial = df['Tiền lương'].var()
std_initial = df['Tiền lương'].std()

mean_10_years = df['Tiền lương sau 10 năm'].mean()
var_10_years = df['Tiền lương sau 10 năm'].var()
std_10_years = df['Tiền lương sau 10 năm'].std()

print(f"Giá trị trung bình ban đầu: {mean_initial}, sau 10 năm: {mean_10_years}")
print(f"Phương sai ban đầu: {var_initial}, sau 10 năm: {var_10_years}")
print(f"Độ lệch chuẩn ban đầu: {std_initial}, sau 10 năm: {std_10_years}")