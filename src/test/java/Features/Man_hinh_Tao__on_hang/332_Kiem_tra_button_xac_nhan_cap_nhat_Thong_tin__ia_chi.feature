# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra button xác nhận cập nhật Thông tin địa chỉ

	Scenario: Kiểm tra button xác nhận cập nhật Thông tin địa chỉ
		Given Tại màn hình Tạo đơn hàng click chọn vùng Thông tin địa chỉ
		When Cập nhật lại địa chỉ tại Tab Thông tin địa chỉ
		Then Xác nhận thông tin địa chỉ đã chọn. Chuyển người dùng về màn hình Tạo đơn hàng với thông tin địa chỉ mới đã cập nhật