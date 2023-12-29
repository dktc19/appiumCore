# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra trường Hình thức thanh toán cước hàng tháng - TH đơn hàng không có dịch vụ billing

	Scenario: Kiểm tra trường Hình thức thanh toán cước hàng tháng - TH đơn hàng không có dịch vụ billing
		Given Tại màn hình Tạo đơn hàng với loại dịch vụ không có hình thức thanh toán cước hàng tháng
		Then Hiển thị mặc định 'Không có thanh toán cước'