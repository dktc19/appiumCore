# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check TH đã tạo khoản thu

	Scenario: Check TH đã tạo khoản thu
		Given Tại màn hình thanh toán với dịch vụ Smart Home
		When Cập thêm thông tin tại màn hình Tạo đơn hàng và nhấn tạo đơn hàng
		And Tap button thanh toán
		Then Hiển thị thông báo 'Đơn hàng đã được tạo khoản thu COD. Vui lòng kiểm tra lại.'