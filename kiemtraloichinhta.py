from docx import Document
#pip install python-docx
from pyvi import ViTokenizer, ViPosTagger
#pip install pyvi
document = Document('522H0148.docx')


# Kiểm tra lỗi chính tả
for paragraph in document.paragraphs:
    text = paragraph.text
    tokens = ViTokenizer.tokenize(text)
    pos_tags = ViPosTagger.postagging(tokens)
    for i in range(len(pos_tags[1])):
        if pos_tags[1][i] == 'Np' or pos_tags[1][i] == 'Nc':
            word = pos_tags[0][i]
            if not ViPosTagger.is_in_vn_dict(word):
                print(f'Lỗi chính tả tại dòng "{text}"')