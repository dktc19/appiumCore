# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check vào màn hình Thanh toán sau khi tạo hợp đồng thành công

	Scenario: Check vào màn hình Thanh toán sau khi tạo hợp đồng thành công
		Given Tại màn hình Thông tin đơn hàng
		When Nhấn button Tạo hợp đồng
		Then Sau khi tạo hợp đồng thành công chuyển sang màn hình Thanh toán