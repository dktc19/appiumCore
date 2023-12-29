# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra màn hình Chi Tiết từ Combo gợi ý cho bạn

	Scenario: Kiểm tra màn hình Chi Tiết từ Combo gợi ý cho bạn
		When Tại màn hình dịch vụ sau khi gói dịch trên combo gợi ý cho bạn
		Then Hiển thị màn hình tạo đơn hàng và tab thông dịch vụ đã chọn
		When Nhấn button chi tiết
		Then Hiển thị màn hình chi tiết