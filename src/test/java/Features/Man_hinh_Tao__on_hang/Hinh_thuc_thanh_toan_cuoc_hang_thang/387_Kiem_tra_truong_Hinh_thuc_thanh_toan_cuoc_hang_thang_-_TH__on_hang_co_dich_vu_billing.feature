# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra trường Hình thức thanh toán cước hàng tháng - TH đơn hàng có dịch vụ billing

	Scenario: Kiểm tra trường Hình thức thanh toán cước hàng tháng - TH đơn hàng có dịch vụ billing
		Given Tại màn hình Tạo đơn hàng
		When Tap droplist Hình thức thanh toán hàng tháng
		When Hiển thị popup Danh sách Hình thức thanh toán cước hàng tháng