# Automation priority: null
# Test case importance: Low
# language: en
Feature: Cập nhật lại dịch vụ Internet

	Scenario: Cập nhật lại dịch vụ Internet
		Given Tại màn hình chi tiết
		When Tab vào dịch vụ Internet
		Then Hiển thị thông tin chi tiết từng dịch vụ
		When Chọn lại thông tin dịch vụ Internet
		Then Check phép chọn lại gói và hiển thị thông tin sau khi chọn