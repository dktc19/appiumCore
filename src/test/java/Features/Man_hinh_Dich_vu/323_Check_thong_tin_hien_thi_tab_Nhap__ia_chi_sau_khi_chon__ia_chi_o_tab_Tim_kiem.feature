# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check thông tin hiển thị tab Nhập địa chỉ sau khi chọn địa chỉ ở tab Tìm kiếm

	Scenario Outline: Check thông tin hiển thị tab Nhập địa chỉ sau khi chọn địa chỉ ở tab Tìm kiếm
		Given Truy cập vào màn hình bản đồ
		When Nhập địa chỉ <DiaChi> muốn tìm kiếm và nhấn tìm kiếm
		And Chọn địa chỉ phù hợp ở list địa chỉ gợi ý
		And Nhấn icon địa chỉ đang được tìm trên map và nhấn xác nhận
		Then Thông tin tab Nhập địa chỉ sẽ tự động điền vào các field bên tab Tìm kiếm

		@1
		Examples:
		| DiaChi |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" |