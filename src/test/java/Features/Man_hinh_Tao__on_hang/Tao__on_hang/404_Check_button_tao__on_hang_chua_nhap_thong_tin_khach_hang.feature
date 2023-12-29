# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check button tạo đơn hàng chưa nhập thông tin khách hàng

	Scenario: Check button tạo đơn hàng chưa nhập thông tin khách hàng
		When Tại màn hình tạo đơn hàng đã chọn thông tin dịch vụ trước đó
		Then Không cập nhật thông tin khách hàng và nhấn button tạo đơn hàng