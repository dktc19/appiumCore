# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check button thanh toán trong 60s

	Scenario: Check button thanh toán trong 60s
		Given Tại màn hình thanh toán , Tap button thanh toán lần 1
		When Tap button thanh toán lần 2
		Then App show thông báo trong 1 popup notification 1 nút Đóng: 'Đang trong thời gian kiểm tra thông tin thanh toán. Vui lòng thử lại sau ít phút nữa.'