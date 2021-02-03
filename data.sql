USE [P0014]
GO
INSERT [dbo].[tbl_Role] ([ID], [name], [description]) VALUES (1, N'admin', N'')
INSERT [dbo].[tbl_Role] ([ID], [name], [description]) VALUES (2, N'student', NULL)
GO
INSERT [dbo].[tbl_User] ([email], [password], [fullname], [roleID], [status]) VALUES (N'admin', N'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', N'admin cute', 1, 1)
INSERT [dbo].[tbl_User] ([email], [password], [fullname], [roleID], [status]) VALUES (N'admin@gmail.com', N'15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', N'admin xau trai', 2, 1)
INSERT [dbo].[tbl_User] ([email], [password], [fullname], [roleID], [status]) VALUES (N'student@gmail.com', N'15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', N'tien 213', 2, 1)
INSERT [dbo].[tbl_User] ([email], [password], [fullname], [roleID], [status]) VALUES (N'tien@gmail.com', N'15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', N'Tien Sad', 2, 1)
INSERT [dbo].[tbl_User] ([email], [password], [fullname], [roleID], [status]) VALUES (N'user', N'04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', N'user cute', 2, 1)
GO
INSERT [dbo].[tbl_Subject] ([ID], [name]) VALUES (N'1', N'java')
INSERT [dbo].[tbl_Subject] ([ID], [name]) VALUES (N'2', N'C#')
INSERT [dbo].[tbl_Subject] ([ID], [name]) VALUES (N'3', N'japanese')
GO
SET IDENTITY_INSERT [dbo].[tbl_Question] ON 

INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (1, N'1', N'admin', 1, 1611533686502, N'thay khanh co cute ko', N'yes', N'rat cute nha', N'yes yes', N'tat nhien roi', 3)
INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (2, N'2', N'admin', 1, 1611534003540, N'ban hoc tieng nhat ai', N'tue', N'thay tue', N'tue cute', N'tue gau truc', 1)
INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (3, N'2', N'admin', 1, 1611535524802, N'ban hoc java web ai?', N'khanh dai ca', N'thay khanh kute', N'ko ai ngoai dai ca khanh', N'khanh kt haha', 2)
INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (4, N'1', N'admin', 0, 1611536129556, N'ai la nguoi sang lap ra FPT', N'truong gia binh', N'kieu trong khanh', N'pham nhat vuong', N'nguyen the hoang', 4)
INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (5, N'1', N'admin', 0, 1611542819760, N'mot tuan co bao nhieu ngay', N'0', N'2', N'5', N'7', 4)
INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (6, N'3', N'admin', 0, 1611559898143, N'a', N'b', N'd', N'd', N'bbb', 1)
INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (7, N'3', N'admin', 0, 1611565125683, N'truong fpt nam o quan may', N'1', N'2', N'3', N'9', 4)
INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (1012, N'1', N'admin', 1, 1611815457571, N'lam sao de co nguoi yeu ?', N'di cua gai', N'de cai cua', N'kiem that nhieu tien', N'ai ma biet', 4)
INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (1015, N'1', N'user', 1, 1611848946114, N'asd', N'as', N'asd', N'asd', N'asd', 3)
INSERT [dbo].[tbl_Question] ([ID], [subjectID], [adminEmail], [status], [createDate], [questionContent], [answerContent1], [answerContent2], [answerContent3], [answerContent4], [correctAnswer]) VALUES (1019, N'1', N'admin', 1, 1612122592635, N'123', N'456', N'123', N'123', N'123', 1)
SET IDENTITY_INSERT [dbo].[tbl_Question] OFF
GO
