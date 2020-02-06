class Rash:
	def wow(self):
		print("Rash is awseome")

class Mad:
	def wow(self):
		print("hey mad ran")

class Ramad(Mad, Rash):
	def cool(self):
		print("cool")

r = Ramad()
r.cool()
r.wow()