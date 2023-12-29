# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra màn hình Tạo đơn hàng khi nhấn btn Chi tiết, CÓ cập nhật ở màn hình chi tiết và quay lại màn hình Tạo đơn hàng

	Scenario: Kiểm tra màn hình Tạo đơn hàng khi nhấn btn Chi tiết, CÓ cập nhật ở màn hình chi tiết và quay lại màn hình Tạo đơn hàng
		Given Tại màn hình Tạo đơn hàng
		When Cập nhật thông tin tại màn hình Chi tiết
		Then Cập nhật lại thông tin sản phẩm/ dịch vụ theo câu lệnh giá của chính sách phù hợp