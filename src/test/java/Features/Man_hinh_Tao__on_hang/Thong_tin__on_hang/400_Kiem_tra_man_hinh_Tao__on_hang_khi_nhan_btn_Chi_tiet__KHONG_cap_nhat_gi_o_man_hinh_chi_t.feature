# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra màn hình Tạo đơn hàng khi nhấn btn Chi tiết, KHÔNG cập nhật gì ở màn hình chi tiết và quay lại màn hình Tạo đơn hàng

	Scenario: Kiểm tra màn hình Tạo đơn hàng khi nhấn btn Chi tiết, KHÔNG cập nhật gì ở màn hình chi tiết và quay lại màn hình Tạo đơn hàng
		Given Tại màn hình Thông tin đơn hàng Tap button Chi tiết và Không cập nhật thông tin ở màn hình Chi tiết
		When Tap button Xác nhận
		Then Thông tin tại màn hình Tạo đơn hàng không đổi