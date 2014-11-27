import os 

def boys_and_girls(): 
	print(os.path.abspath(os.getcwd()))
	with open("/Users/mlee43/Desktop/PRSAVES/names.txt", 'r') as f:
		for line in f:
		    if 'Ms.' in line:
		        return line    

student= boys_and_girls()

class Pupil: 
	def __init__(self, name, favorite_subject):
		self.name = name 
		self.favorite_subject = favorite_subject 
	def attendance(self): 
		print "Present! " + self.name + " is here!" 
	def class_list(self): 
		text_file = open("class_list.txt", "w")
		text_file.write(self.name + ", " + self.favorite_subject)
		text_file.close()	 

the_girl =  Pupil(student, "math") 
the_girl.attendance()
the_girl.class_list()