# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra thông tin đơn hàng khi mua dịch vụ net

	Scenario Outline: Kiểm tra thông tin đơn hàng khi mua dịch vụ net
		Given Truy cập màn hình Dịch vụ
		When Tại popup Internet Tap Dropdown list Gói dịch vụ Net <DiaChi>
		And Chọn Gói dịch vụ <DichVu> và Gói tính cước Net <GoiTinhCuoc>
		And Tap button Xác nhận
		Then Hiển thị thông tin đã chọn ở màn hình Tạo đơn hàng và Highlight Icon Internet tại màn hình Dịch vụ

		@1
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super100" | "Gói 3T (3T+0)" |

		@10
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "LUX - 500" | "Gói 7T (6T+1)" |

		@11
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "LUX - 800" | "Gói 7T (6T+1)" |

		@12
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "Meta" | "Gói 7T (6T+1)" |

		@2
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super150" | "Gói 3T (3T+0)" |

		@3
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super200" | "Gói 12T (12T+0)" |

		@4
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super250" | "Gói 12T (12T+0)" |

		@5
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super30" | "Gói 7T (6T+1)" |

		@6
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super400" | "Gói 7T (6T+1)" |

		@7
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super500" | "Gói 12T (12T+0)" |

		@8
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "" | "FTTH - Super80" | "Gói 12T (12T+0)" |

		@9
		Examples:
		| DiaChi | DichVu | GoiTinhCuoc |
		| "" | "Giga" | "Gói 3T (3T+0)" |