import unittest

from cal import *

class TestUs(unittest.TestCase):
	
	def setUp(self):
		self.nums1 = [1.0, 0.0, -1.0]
		self.nums2 = [2, 2, 2]
		
		self.num_a = [3, 2, 1]
		self.num_m = [2, 0, -2]
		
		self.num_s1 = [-1, -2, -3]
		self.num_s2 = [1, 2, 3]
		
		self.num_d1 = [0.5, 0, -0.5]
		self.num_d2 = [2, 0, -2]
	
	# Since a + b = b + a, there's no need to add an extra test case
	def test_for_add_function(self):
		for i in range (0, len(self.nums1)):
			self.assertEqual( add(self.nums1[i], self.nums2[i]), self.num_a[i])
	
	# Since a * b = b * a, there's no need to add an extra test case
	def test_for_multiply_function(self):
		for i in range (0, len(self.nums1)):
			self.assertEqual( multiply(self.nums1[i], self.nums2[i]), self.num_m[i])
			
			
	# Subtract (a, b)
	def test_for_subtract_function_one(self):
		for i in range (0, len(self.nums1)):
			self.assertEqual( subtract(self.nums1[i], self.nums2[i]), self.num_s1[i])

	# Subtract (b, a)
	def test_for_subtract_function_two(self):
		for i in range (0, len(self.nums1)):
			self.assertEqual( subtract(self.nums2[i], self.nums1[i]), self.num_s2[i])

	# Divide (a, b)
	def test_for_divide_function_one(self):
		for i in range (0, len(self.nums1)):
			self.assertEqual( divide(self.nums1[i], self.nums2[i]), self.num_d1[i])
			
	# Divide (b, a)
	def test_for_divide_function_one(self):
		self.assertRaises(Exception,lambda: divide(1, 0))
		
		

	

		
if __name__ == '__main__':
	unittest.main()
