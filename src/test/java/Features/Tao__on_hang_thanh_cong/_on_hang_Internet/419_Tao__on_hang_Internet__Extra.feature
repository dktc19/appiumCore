# Automation priority: null
# Test case importance: Low
# language: en
Feature: Tạo đơn hàng Internet +Extra

	Scenario Outline: Tạo đơn hàng Internet +Extra
		Given Login vào tk SPF thành công bằng <Account> và <Password>
		When Nhấn Tất cả dịch vụ tại màn hình trang chủ
		And Nhấn button Bán mới
		And Truy cập màn hình nhập địa chỉ
		And Nhập địa chỉ <DiaChi> muốn tìm kiếm và nhấn tìm kiếm
		And Chọn địa chỉ phù hợp ở list địa chỉ gợi ý
		And Nhấn icon địa chỉ đang được tìm trên map và nhấn xác nhận
		Then Hiển thị màn hình dịch vụ
		When Tại combo tùy chọn nhấn icon Internet
		When Chọn gói dịch vụ <DichVu>, Chọn gói tính cước <GoiTinhCuoc> Chọn gói Extra
		And Nhấn xác nhận
		Then Truy cập màn hình chi tiết
		When Nhấn xác nhận
		And Chờ màn hình tạo đơn hàng tải thành công
		When Nhấn cập nhật thông tin khách hàng
		And Nhập thông tin khách hàng
		And Nhấn xác nhận & lưu
		Then Hiển thị màn hình tạo đơn hàng có thông tin khách hàng đã nhập
		When Chọn phương thức thanh toán tiền mặt
		Then Kiểm tra thông tin dịch vụ Internet
		And Kiểm tra book port
		And Kiểm tra thông tin thanh toán
		When Nhấn button tạo đơn hàng
		Then Tạo đơn hàng thành công và hiển thị màn hình chi tiết đơn hàng

		@1
		Examples:
		| Account | DiaChi | DichVu | Extra | GoiTinhCuoc | Password | extra |
		| "QC.GiangHNL" | "100 Lê Trọng Tấn, phương Tây Thạnh, quận Tân Phú, HCM" | "FTTH - Supper100" | "F-Safe" | "Gói 3T (3T+0)" | "1" | "" |

		@2
		Examples:
		| Account | DiaChi | DichVu | Extra | GoiTinhCuoc | Password | extra |
		| "HCM.NhuDTH5" | "300 Nguyễn Thị Thập," | "FTTH - Supper80" | "Ultra Fast" | "Gói 7T (6T+1)" | "Test123456@" | "" |

		@3
		Examples:
		| Account | DiaChi | DichVu | Extra | GoiTinhCuoc | Password | extra |
		| "HCM.NhuDTH5" | "400 Huỳnh Tấn Phát, phường Tân Thuận Đông ,quận 7" | "FTTH - Supper150" | "IP Tĩnh" | "Gói 14T (12T+2)" | "Test123456@" | "" |