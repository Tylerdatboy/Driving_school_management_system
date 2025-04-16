INSERT INTO drivingschool.aboutus (addtime,title,subtitle,content,picture1,picture2,picture3) VALUES
	 ('2023-03-11 19:58:59','About Us','ABOUT US','不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?
你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。其实，我已经厌倦了你这样说说而已的把戏，我觉得就算我告诉你如何去做，你也不会照做，因为你根本什么都不做。','upload/aboutus_picture1.jpg','upload/aboutus_picture2.jpg','upload/aboutus_picture3.jpg');
INSERT INTO drivingschool.cheliangweihu (addtime,chepaihao,cheliangmingcheng,cheliangleixing,weihushijian,weihuneirong,weihujieguo) VALUES
	 ('2023-03-11 19:58:59','车牌号1','车辆名称1','车辆类型1','2023-03-11','维护内容1','维护结果1'),
	 ('2023-03-11 19:58:59','车牌号2','车辆名称2','车辆类型2','2023-03-11','维护内容2','维护结果2'),
	 ('2023-03-11 19:58:59','车牌号3','车辆名称3','车辆类型3','2023-03-11','维护内容3','维护结果3'),
	 ('2023-03-11 19:58:59','车牌号4','车辆名称4','车辆类型4','2023-03-11','维护内容4','维护结果4'),
	 ('2023-03-11 19:58:59','车牌号5','车辆名称5','车辆类型5','2023-03-11','维护内容5','维护结果5'),
	 ('2023-03-11 19:58:59','车牌号6','车辆名称6','车辆类型6','2023-03-11','维护内容6','维护结果6'),
	 ('2023-03-11 19:58:59','车牌号7','车辆名称7','车辆类型7','2023-03-11','维护内容7','维护结果7'),
	 ('2023-03-11 19:58:59','车牌号8','车辆名称8','车辆类型8','2023-03-11','维护内容8','维护结果8');
INSERT INTO drivingschool.coaching_schedule (selectedCoach,studentName,scheduleDate,startTime,endTime) VALUES
	 ('1','李学员','2025-03-31','08:00','10:00'),
	 ('2','Student account1','2025-03-35','08:00','10:00'),
	 ('3','Student account1','2025-03-25','08:00','10:00'),
	 ('1','Student account1','2025-03-25','08:00','10:00'),
	 ('1','Student account1','2025-03-25','10:00','12:00'),
	 ('1','Student account1','2025-03-25','14:00','16:00'),
	 ('1','Student account1','2025-03-25','16:00','18:00'),
	 ('1','Student account1','2025-03-30','19:00','21:00'),
	 ('1','Student account1','2025-03-30','08:00','10:00'),
	 ('21','Student account1','2025-03-26','08:00','10:00');
INSERT INTO drivingschool.coaching_schedule (selectedCoach,studentName,scheduleDate,startTime,endTime) VALUES
	 ('21','Student account1','2025-03-26','08:00','10:00'),
	 ('21','Student account1','2025-03-30','08:00','10:00'),
	 ('22','Student account1','2025-03-29','08:00','10:00'),
	 ('22','Coach account2','2025-03-30','10:00','12:00'),
	 ('21','Student account1','2025-04-01','08:00','10:00'),
	 ('22','Student account1','2025-04-01','08:00','10:00');
INSERT INTO drivingschool.config (name,value) VALUES
	 ('picture1','upload/picture1.jpg'),
	 ('picture2','upload/picture2.jpg'),
	 ('picture3','upload/picture3.jpg');
INSERT INTO drivingschool.fenpeijiaolian (addtime,jiaolianzhanghao,jiaolianxingming,lianxidianhua,xueyuanzhanghao,xueyuanxingming,xueyuanshouji,fenpeishijian,crossuserid,crossrefid) VALUES
	 ('2023-03-11 19:58:59','Coach account1','Coach Name1','Contact Number1','Student account1','Student name1','Student mobile phone1','2023-03-11 19:58:59',1,1),
	 ('2023-03-11 19:58:59','Coach account2','Coach Name2','Contact Number2','Student account2','Student name2','Student mobile phone2','2023-03-11 19:58:59',2,2),
	 ('2023-03-11 19:58:59','Coach account3','Coach Name3','Contact Number3','Student account3','Student name3','Student mobile phone3','2023-03-11 19:58:59',3,3),
	 ('2023-03-11 19:58:59','Coach account4','Coach Name4','Contact Number4','Student account4','Student name4','Student mobile phone4','2023-03-11 19:58:59',4,4),
	 ('2023-03-11 19:58:59','Coach account5','Coach Name5','Contact Number5','Student account5','Student name5','Student mobile phone5','2023-03-11 19:58:59',5,5),
	 ('2023-03-11 19:58:59','Coach account6','Coach Name6','Contact Number6','Student account6','Student name6','Student mobile phone6','2023-03-11 19:58:59',6,6),
	 ('2023-03-11 19:58:59','Coach account7','Coach Name7','Contact Number7','Student account7','Student name7','Student mobile phone7','2023-03-11 19:58:59',7,7),
	 ('2023-03-11 19:58:59','Coach account8','Coach Name8','Contact Number8','Student account8','Student name8','Student mobile phone8','2023-03-11 19:58:59',8,8);
INSERT INTO drivingschool.jiaofeixinxi (addtime,jiaxiaomingcheng,lianxifangshi,jiaxiaodizhi,xueyuanzhanghao,xueyuanxingming,xueyuanshouji,xuefei,baomingshijian,ispay) VALUES
	 ('2023-03-11 19:58:59','Name of driving school1','contact information1','Driving school address1','Student account1','Student name1','Student mobile phone1',1.0,'2023-03-11 19:58:59','未支付'),
	 ('2023-03-11 19:58:59','Name of driving school2','contact information2','Driving school address2','Student account2','Student name2','Student mobile phone2',2.0,'2023-03-11 19:58:59','未支付'),
	 ('2023-03-11 19:58:59','Name of driving school3','contact information3','Driving school address3','Student account3','Student name3','Student mobile phone3',3.0,'2023-03-11 19:58:59','未支付'),
	 ('2023-03-11 19:58:59','Name of driving school4','contact information4','Driving school address4','Student account4','Student name4','Student mobile phone4',4.0,'2023-03-11 19:58:59','未支付'),
	 ('2023-03-11 19:58:59','Name of driving school5','contact information5','Driving school address5','Student account5','Student name5','Student mobile phone5',5.0,'2023-03-11 19:58:59','未支付'),
	 ('2023-03-11 19:58:59','Name of driving school6','contact information6','Driving school address6','Student account6','Student name6','Student mobile phone6',6.0,'2023-03-11 19:58:59','未支付'),
	 ('2023-03-11 19:58:59','Name of driving school7','contact information7','Driving school address7','Student account7','Student name7','Student mobile phone7',7.0,'2023-03-11 19:58:59','未支付'),
	 ('2023-03-11 19:58:59','Name of driving school8','contact information8','Driving school address8','Student account8','Student name8','Student mobile phone8',8.0,'2023-03-11 19:58:59','未支付');
INSERT INTO drivingschool.jiaolianpingjia (addtime,jiaolianzhanghao,jiaolianxingming,lianxidianhua,xueyuanzhanghao,xueyuanxingming,xueyuanshouji,lianxikemu,pingjia) VALUES
	 ('2023-03-11 19:58:59','Coach account1','Coach Name1','Contact Number1','Student account1','Student name1','Student mobile phone1','Practice subjects1',' evaluate1'),
	 ('2023-03-11 19:58:59','Coach account2','Coach Name2','Contact Number2','Student account2','Student name2','Student mobile phone2','Practice subjects2',' evaluate2'),
	 ('2023-03-11 19:58:59','Coach account3','Coach Name3','Contact Number3','Student account3','Student name3','Student mobile phone3','Practice subjects3',' evaluate3'),
	 ('2023-03-11 19:58:59','Coach account4','Coach Name4','Contact Number4','Student account4','Student name4','Student mobile phone4','Practice subjects4',' evaluate4'),
	 ('2023-03-11 19:58:59','Coach account5','Coach Name5','Contact Number5','Student account5','Student name5','Student mobile phone5','Practice subjects5',' evaluate5'),
	 ('2023-03-11 19:58:59','Coach account6','Coach Name6','Contact Number6','Student account6','Student name6','Student mobile phone6','Practice subjects6',' evaluate6'),
	 ('2023-03-11 19:58:59','Coach account7','Coach Name7','Contact Number7','Student account7','Student name7','Student mobile phone7','Practice subjects7',' evaluate7'),
	 ('2023-03-11 19:58:59','Coach account8','Coach Name8','Contact Number8','Student account8','Student name8','Student mobile phone8','Practice subjects8',' evaluate8');
INSERT INTO drivingschool.jiaxiaobaoming (addtime,jiaxiaomingcheng,lianxifangshi,xuefei,fengmian,jiaxiaodizhi) VALUES
	 ('2023-03-11 19:58:59','Name of driving school1','contact information1',1.0,'upload/jiaxiaobaoming_fengmian1.jpg,upload/jiaxiaobaoming_fengmian2.jpg,upload/jiaxiaobaoming_fengmian3.jpg','Driving school address1'),
	 ('2023-03-11 19:58:59','Name of driving school2','contact information2',2.0,'upload/jiaxiaobaoming_fengmian2.jpg,upload/jiaxiaobaoming_fengmian3.jpg,upload/jiaxiaobaoming_fengmian4.jpg','Driving school address2'),
	 ('2023-03-11 19:58:59','Name of driving school3','contact information3',3.0,'upload/jiaxiaobaoming_fengmian3.jpg,upload/jiaxiaobaoming_fengmian4.jpg,upload/jiaxiaobaoming_fengmian5.jpg','Driving school address3'),
	 ('2023-03-11 19:58:59','Name of driving school4','contact information4',4.0,'upload/jiaxiaobaoming_fengmian4.jpg,upload/jiaxiaobaoming_fengmian5.jpg,upload/jiaxiaobaoming_fengmian6.jpg','Driving school address4'),
	 ('2023-03-11 19:58:59','Name of driving school5','contact information5',5.0,'upload/jiaxiaobaoming_fengmian5.jpg,upload/jiaxiaobaoming_fengmian6.jpg,upload/jiaxiaobaoming_fengmian7.jpg','Driving school address5'),
	 ('2023-03-11 19:58:59','Name of driving school6','contact information6',6.0,'upload/jiaxiaobaoming_fengmian6.jpg,upload/jiaxiaobaoming_fengmian7.jpg,upload/jiaxiaobaoming_fengmian8.jpg','Driving school address6'),
	 ('2023-03-11 19:58:59','Name of driving school7','contact information7',7.0,'upload/jiaxiaobaoming_fengmian7.jpg,upload/jiaxiaobaoming_fengmian8.jpg,upload/jiaxiaobaoming_fengmian9.jpg','Driving school address7'),
	 ('2023-03-11 19:58:59','Name of driving school8','contact information8',8.0,'upload/jiaxiaobaoming_fengmian8.jpg,upload/jiaxiaobaoming_fengmian9.jpg,upload/jiaxiaobaoming_fengmian10.jpg','Driving school address8');
INSERT INTO drivingschool.jiaxiaocheliang (addtime,chepaihao,cheliangmingcheng,cheliangleixing,kemu,cheliangtupian,cheliangxiangqing,jiaolianzhanghao,jiaolianxingming) VALUES
	 ('2023-03-11 19:58:59','车牌号1','车辆名称1','训练车','科目二','upload/jiaxiaocheliang_cheliangtupian1.jpg,upload/jiaxiaocheliang_cheliangtupian2.jpg,upload/jiaxiaocheliang_cheliangtupian3.jpg','车辆info1','Coach account1','Coach Name1'),
	 ('2023-03-11 19:58:59','车牌号2','车辆名称2','训练车','科目二','upload/jiaxiaocheliang_cheliangtupian2.jpg,upload/jiaxiaocheliang_cheliangtupian3.jpg,upload/jiaxiaocheliang_cheliangtupian4.jpg','车辆info2','Coach account2','Coach Name2'),
	 ('2023-03-11 19:58:59','车牌号3','车辆名称3','训练车','科目二','upload/jiaxiaocheliang_cheliangtupian3.jpg,upload/jiaxiaocheliang_cheliangtupian4.jpg,upload/jiaxiaocheliang_cheliangtupian5.jpg','车辆info3','Coach account3','Coach Name3'),
	 ('2023-03-11 19:58:59','车牌号4','车辆名称4','训练车','科目二','upload/jiaxiaocheliang_cheliangtupian4.jpg,upload/jiaxiaocheliang_cheliangtupian5.jpg,upload/jiaxiaocheliang_cheliangtupian6.jpg','车辆info4','Coach account4','Coach Name4'),
	 ('2023-03-11 19:58:59','车牌号5','车辆名称5','训练车','科目二','upload/jiaxiaocheliang_cheliangtupian5.jpg,upload/jiaxiaocheliang_cheliangtupian6.jpg,upload/jiaxiaocheliang_cheliangtupian7.jpg','车辆info5','Coach account5','Coach Name5'),
	 ('2023-03-11 19:58:59','车牌号6','车辆名称6','训练车','科目二','upload/jiaxiaocheliang_cheliangtupian6.jpg,upload/jiaxiaocheliang_cheliangtupian7.jpg,upload/jiaxiaocheliang_cheliangtupian8.jpg','车辆info6','Coach account6','Coach Name6'),
	 ('2023-03-11 19:58:59','车牌号7','车辆名称7','训练车','科目二','upload/jiaxiaocheliang_cheliangtupian7.jpg,upload/jiaxiaocheliang_cheliangtupian8.jpg,upload/jiaxiaocheliang_cheliangtupian9.jpg','车辆info7','Coach account7','Coach Name7'),
	 ('2023-03-11 19:58:59','车牌号8','车辆名称8','训练车','科目二','upload/jiaxiaocheliang_cheliangtupian8.jpg,upload/jiaxiaocheliang_cheliangtupian9.jpg,upload/jiaxiaocheliang_cheliangtupian10.jpg','车辆info8','Coach account8','Coach Name8');
INSERT INTO drivingschool.jiaxiaojiaolian (addtime,jiaolianzhanghao,mima,jiaolianxingming,nianling,xingbie,jiaoling,touxiang,lianxidianhua,gerenjieshao,pquestion,panswer) VALUES
	 ('2023-03-11 19:58:59','Coach account1','123456','Coach Name1',1,'man','Length of teaching1','upload/jiaxiaojiaolian_touxiang1.jpg','13823888881','个人介绍1','security question1','Secret Answer1'),
	 ('2023-03-11 19:58:59','Coach account2','123456','Coach Name2',2,'man','Length of teaching2','upload/jiaxiaojiaolian_touxiang2.jpg','13823888882','个人介绍2','security question2','Secret Answer2'),
	 ('2023-03-11 19:58:59','Coach account3','123456','Coach Name3',3,'man','Length of teaching3','upload/jiaxiaojiaolian_touxiang3.jpg','13823888883','个人介绍3','security question3','Secret Answer3'),
	 ('2023-03-11 19:58:59','Coach account4','123456','Coach Name4',4,'man','Length of teaching4','upload/jiaxiaojiaolian_touxiang4.jpg','13823888884','个人介绍4','security question4','Secret Answer4'),
	 ('2023-03-11 19:58:59','Coach account5','123456','Coach Name5',5,'man','Length of teaching5','upload/jiaxiaojiaolian_touxiang5.jpg','13823888885','个人介绍5','security question5','Secret Answer5'),
	 ('2023-03-11 19:58:59','Coach account6','123456','Coach Name6',6,'man','Length of teaching6','upload/jiaxiaojiaolian_touxiang6.jpg','13823888886','个人介绍6','security question6','Secret Answer6'),
	 ('2023-03-11 19:58:59','Coach account7','123456','Coach Name7',7,'man','Length of teaching7','upload/jiaxiaojiaolian_touxiang7.jpg','13823888887','个人介绍7','security question7','Secret Answer7'),
	 ('2023-03-11 19:58:59','Coach account8','123456','Coach Name8',8,'man','Length of teaching8','upload/jiaxiaojiaolian_touxiang8.jpg','13823888888','个人介绍8','security question8','Secret Answer8');
INSERT INTO drivingschool.kaoshianpai (addtime,jiaolianzhanghao,jiaolianxingming,lianxidianhua,xueyuanzhanghao,xueyuanxingming,xueyuanshouji,kaoshishijian,kaoshikemu,kaoshididian) VALUES
	 ('2023-03-11 19:58:59','Coach account1','Coach Name1','Contact Number1','Student account1','Student name1','Student mobile phone1','2023-03-11 19:58:59','科目一','Exam place1'),
	 ('2023-03-11 19:58:59','Coach account2','Coach Name2','Contact Number2','Student account2','Student name2','Student mobile phone2','2023-03-11 19:58:59','科目一','Exam place2'),
	 ('2023-03-11 19:58:59','Coach account3','Coach Name3','Contact Number3','Student account3','Student name3','Student mobile phone3','2023-03-11 19:58:59','科目一','Exam place3'),
	 ('2023-03-11 19:58:59','Coach account4','Coach Name4','Contact Number4','Student account4','Student name4','Student mobile phone4','2023-03-11 19:58:59','科目一','Exam place4'),
	 ('2023-03-11 19:58:59','Coach account5','Coach Name5','Contact Number5','Student account5','Student name5','Student mobile phone5','2023-03-11 19:58:59','科目一','Exam place5'),
	 ('2023-03-11 19:58:59','Coach account6','Coach Name6','Contact Number6','Student account6','Student name6','Student mobile phone6','2023-03-11 19:58:59','科目一','Exam place6'),
	 ('2023-03-11 19:58:59','Coach account7','Coach Name7','Contact Number7','Student account7','Student name7','Student mobile phone7','2023-03-11 19:58:59','科目一','Exam place7'),
	 ('2023-03-11 19:58:59','Coach account8','Coach Name8','Contact Number8','Student account8','Student name8','Student mobile phone8','2023-03-11 19:58:59','科目一','Exam place8');
INSERT INTO drivingschool.news (addtime,title,introduction,picture,content) VALUES
	 ('2023-03-11 19:58:59','有梦想，就要努力去实现','不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。','upload/news_picture1.jpg','<p>不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?</p><p>你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。其实，我已经厌倦了你这样说说而已的把戏，我觉得就算我告诉你如何去做，你也不会照做，因为你根本什么都不做。</p><p>真正有行动力的人不需要别人告诉他如何做，因为他已经在做了。就算碰到问题，他也会自己想办法，自己动手去解决或者主动寻求可以帮助他的人，而不是等着别人为自己解决问题。</p><p>首先要学习独立思考。花一点时间想一下自己喜欢什么，梦想是什么，不要别人说想环游世界，你就说你的梦想是环游世界。</p><p>很多人说现实束缚了自己，其实在这个世界上，我们一直都可以有很多选择，生活的决定权也—直都在自己手上，只是我们缺乏行动力而已。</p><p>如果你觉得安于现状是你想要的，那选择安于现状就会让你幸福和满足;如果你不甘平庸，选择一条改变、进取和奋斗的道路，在这个追求的过程中，你也一样会感到快乐。所谓的 success，即是按照自己想要的生活方式生活。最糟糕的状态，莫过于当你想要选择一条不甘平庸、改变、进取和奋斗的道路时，却以一种安于现状的方式生活，最后抱怨自己没有得到想要的人生。</p><p>因为喜欢，你不是在苦苦坚持，也因为喜欢，你愿意投入时间、精力，长久以往，获得 success就是自然而然的事情。</p>'),
	 ('2023-03-11 19:58:59','又是一年毕业季','又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。','upload/news_picture2.jpg','<p>又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。</p><p>过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。一直都是晚会的忠实参与者，无论是台前还是幕后，忽然间，角色转变，那种感觉确实难以用语言表达。</p><p>	过去的三年，总是默默地期盼着这个好雨时节，因为这时候，会有灿烂的阳光，会有满目的百花争艳，会有香甜的冰激凌，这是个毕业的季节，当时不经世事的我们会殷切地期待学校那一大堆的活动，期待穿上绚丽的演出服或者礼仪服，站在大礼堂镁光灯下尽情挥洒我们的澎拜的激情。</p><p>百感交集，隔岸观火与身临其境的感觉竟是如此不同。从来没想过一场晚会送走的是我们自己的时候会是怎样的感情，毕业就真的意味着结束吗?倔强的我们不愿意承认，谢谢学弟学妹们慷慨的将这次的主题定为“我们在这里”。我知道，这可能是他们对我们这些过来人的尊敬和施舍。</p><p>没有为这场晚会排练、奔波，没有为班级、学生会、文学院出点力，还真有点不习惯，百般无奈中，用“工作忙”个万能的借口来搪塞自己，欺骗别人。其实自己心里明白，那只是在逃避，只是不愿面对繁华落幕后的萧条和落寞。大四了，大家各奔东西，想凑齐班上的人真的是难上加难，敏燕从越南回来，刚落地就匆匆回了学校，那么恋家的人也启程回来了，睿睿学姐也是从家赶来跟我们团圆。大家—如既往的寒暄、打趣、调侃对方，似乎一切又回到了当初的单纯美好。</p><p>看着舞台上活泼可爱的学弟学妹们，如同一群机灵的小精灵，清澈的眼神，稚嫩的肢体，轻快地步伐，用他们那热情洋溢的舞姿渲染着在场的每一个人，我知道，我不应该羡慕嫉妒他们，不应该顾自怜惜逝去的青春，不应该感叹夕阳无限好，曾经，我们也拥有过，曾经，我们也年轻过，曾经，我们也灿烂过。我深深地告诉自己，人生的每个阶段都是美的，年轻有年轻的活力，成熟也有成熟的魅力。多—份稳重、淡然、优雅，也是漫漫时光掠影遗留下的.珍贵赏赐。</p>'),
	 ('2023-03-11 19:58:59','挫折路上，坚持常在心间','回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是 success运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。','upload/news_picture3.jpg','<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是 success运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度赞赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>'),
	 ('2023-03-11 19:58:59','挫折是另一个生命的开端','当遇到挫折或失败，你是看见失败还是看见机会?挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。','upload/news_picture4.jpg','<p>当遇到挫折或失败，你是看见失败还是看见机会?</p><p>挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。</p><p>人生在世，从古到今，不分天子平民，机遇虽有不同，但总不免有身陷困境或遭遇难题之处，这时候唯有通权达变，才能使人转危为安，甚至反败为胜。</p><p>大部分的人，一生当中，最痛苦的经验是失去所爱的人，其次是丢掉一份工作。其实，经得起考验的人，就算是被开除也不会惊慌，要学会面对。</p><p>	“塞翁失马，焉知非福。”人生的道路，并不是每一步都迈向 success，这就是追求的意义。我们还要认识到一点，挫折作为一种情绪状态和一种个人体验，各人的耐受性是大不相同的，有的人经历了一次次挫折，就能够坚忍不拔，百折不挠;有的人稍遇挫折便意志消沉，一蹶不振。所以，挫折感是一种主观感受，因为人的目的和需要不同， success标准不同，所以同一种活动对于不同的人可能会造成不同的挫折感受。</p><p>凡事皆以平常心来看待，对于生命顺逆不要太执著。能够“破我执”是很高层的人生境界。</p><p>人事的艰难就是一种考验。就像—支剑要有磨刀来磨，剑才会利:一块璞玉要有粗石来磨，才会发出耀眼的光芒。我们能够做到的，只是如何减少、避免那些由于自身的old 因所造成的挫折，而在遇到痛苦和挫折之后，则力求化解痛苦，争取幸福。我们要知道，痛苦和挫折是双重性的，它既是我们人生中难以完全避免的，也是我们在争取 success时，不可缺少的一种动力。因为我认为，推动我们奋斗的力量，不仅仅是对 success的渴望，还有为摆脱痛苦和挫折而perform的奋斗。</p>'),
	 ('2023-03-11 19:58:59','你要去相信，没有到不了的明天','有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。','upload/news_picture5.jpg','<p>有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。</p><p>不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。</p><p>	不管你现在是在图书馆里背着怎么也看不进去的英语单词，还是你现在迷茫地看不清未来的方向不知道要往哪走。</p><p>不管你现在是在努力着去实现梦想却没能拉近与梦想的距离，还是你已经慢慢地找不到自己的梦想了。</p><p>你都要去相信，没有到不了的明天。</p><p>	有的时候你的梦想太大，别人说你的梦想根本不可能实现;有的时候你的梦想又太小，又有人说你胸无大志;有的时候你对死党说着将来要去环游世界的梦想，却换来他的不屑一顾，于是你再也不提自己的梦想;有的时候你突然说起将来要开个小店的愿望，却发现你讲述的那个人，并没有听到你在说什么。</p><p>不过又能怎么样呢，未来始终是自己的，梦想始终是自己的，没有人会来帮你实现它。</p><p>也许很多时候我们只是需要朋友的一句鼓励，一句安慰，却也得不到。但是相信我，世界上还有很多人，只是想要和你说说话。</p><p>因为我们都一样。一样的被人说成固执，一样的在追逐他们眼里根本不在意的东西。</p><p>所以，又有什么关系呢，别人始终不是你、不能懂你的心情，你又何必多去解释呢。这个世界会来阻止你，困难也会接踵而至，其实真正关键的只有自己，有没有那个倔强。</p><p>这个世界上没有不带伤的人，真正能治愈自己的，只有自己。</p>'),
	 ('2023-03-11 19:58:59','离开是一种痛苦，是一种勇气，但同样也是一个考验，是一个新的开端','无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。','upload/news_picture6.jpg','<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够sure自己的新起点，坚持不懈，向着更新、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在 success时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>'),
	 ('2023-03-11 19:58:59','Leave未必是一种痛苦','无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。','upload/news_picture7.jpg','<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够sure自己的新起点，坚持不懈，向着更新、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在 success时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>'),
	 ('2023-03-11 19:58:59','坚持才会 success','回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是 success运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。','upload/news_picture8.jpg','<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是 success运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度赞赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>');
INSERT INTO drivingschool.systemintro (addtime,title,subtitle,content,picture1,picture2,picture3) VALUES
	 ('2023-03-11 19:58:59','System Introduction','SYSTEM INTRODUCTION','当遇到挫折或失败，你是看见失败还是看见机会?挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。人生在世，从古到今，不分天子平民，机遇虽有不同，但总不免有身陷困境或遭遇难题之处，这时候唯有通权达变，才能使人转危为安，甚至反败为胜。大部分的人，一生当中，最痛苦的经验是失去所爱的人，其次是丢掉一份工作。其实，经得起考验的人，就算是被开除也不会惊慌，要学会面对。','upload/systemintro_picture1.jpg','upload/systemintro_picture2.jpg','upload/systemintro_picture3.jpg');
INSERT INTO drivingschool.token (userid,username,tablename,`role`,token,addtime,expiratedtime) VALUES
	 (1,'admin','users','admin','1nuxu6433c90bdpq1ap0p9jjt506u3tt','2025-03-23 22:05:58','2025-03-23 15:14:44'),
	 (11,'Student account1','xueyuan','student','v3r59td972g2gxl1xbfr3ll6p6apfgsi','2025-03-23 22:12:43','2025-03-31 09:35:23'),
	 (21,'Coach account1','jiaxiaojiaolian','Driving school coach','902f52b4xtb7vzhm4yh8n61ejjge4lvx','2025-03-23 22:15:30','2025-03-31 09:34:56'),
	 (22,'Coach account2','jiaxiaojiaolian','Driving school coach','2cxitnxzcl07d11afczuv9994gt1jdrz','2025-03-25 11:55:22','2025-03-25 06:26:14');
INSERT INTO drivingschool.users (username,password,`role`,addtime) VALUES
	 ('admin','admin','admin','2023-03-11 19:58:59');
INSERT INTO drivingschool.xuexijihua (addtime,jiaolianzhanghao,jiaolianxingming,lianxidianhua,xueyuanzhanghao,xueyuanxingming,xueyuanshouji,jihuashijian,jihuaneirong,jihuaanpai) VALUES
	 ('2023-03-11 19:58:59','Coach account1','Coach Name1','Contact Number1','Student account1','Student name1','Student mobile phone1','2023-03-11 19:58:59','计划内容1','计划安排1'),
	 ('2023-03-11 19:58:59','Coach account2','Coach Name2','Contact Number2','Student account2','Student name2','Student mobile phone2','2023-03-11 19:58:59','计划内容2','计划安排2'),
	 ('2023-03-11 19:58:59','Coach account3','Coach Name3','Contact Number3','Student account3','Student name3','Student mobile phone3','2023-03-11 19:58:59','计划内容3','计划安排3'),
	 ('2023-03-11 19:58:59','Coach account4','Coach Name4','Contact Number4','Student account4','Student name4','Student mobile phone4','2023-03-11 19:58:59','计划内容4','计划安排4'),
	 ('2023-03-11 19:58:59','Coach account5','Coach Name5','Contact Number5','Student account5','Student name5','Student mobile phone5','2023-03-11 19:58:59','计划内容5','计划安排5'),
	 ('2023-03-11 19:58:59','Coach account6','Coach Name6','Contact Number6','Student account6','Student name6','Student mobile phone6','2023-03-11 19:58:59','计划内容6','计划安排6'),
	 ('2023-03-11 19:58:59','Coach account7','Coach Name7','Contact Number7','Student account7','Student name7','Student mobile phone7','2023-03-11 19:58:59','计划内容7','计划安排7'),
	 ('2023-03-11 19:58:59','Coach account8','Coach Name8','Contact Number8','Student account8','Student name8','Student mobile phone8','2023-03-11 19:58:59','计划内容8','计划安排8');
INSERT INTO drivingschool.xueyuan (addtime,xueyuanzhanghao,mima,xueyuanxingming,xingbie,xueyuanshouji,shenfenzheng,touxiang,pquestion,panswer) VALUES
	 ('2023-03-11 19:58:59','Student account1','123456','Student name1','man','13823888881','440300199101010001','upload/xueyuan_touxiang1.jpg','security question1','Secret Answer1'),
	 ('2023-03-11 19:58:59','Student account2','123456','Student name2','man','13823888882','440300199202020002','upload/xueyuan_touxiang2.jpg','security question2','Secret Answer2'),
	 ('2023-03-11 19:58:59','Student account3','123456','Student name3','man','13823888883','440300199303030003','upload/xueyuan_touxiang3.jpg','security question3','Secret Answer3'),
	 ('2023-03-11 19:58:59','Student account4','123456','Student name4','man','13823888884','440300199404040004','upload/xueyuan_touxiang4.jpg','security question4','Secret Answer4'),
	 ('2023-03-11 19:58:59','Student account5','123456','Student name5','man','13823888885','440300199505050005','upload/xueyuan_touxiang5.jpg','security question5','Secret Answer5'),
	 ('2023-03-11 19:58:59','Student account6','123456','Student name6','man','13823888886','440300199606060006','upload/xueyuan_touxiang6.jpg','security question6','Secret Answer6'),
	 ('2023-03-11 19:58:59','Student account7','123456','Student name7','man','13823888887','440300199707070007','upload/xueyuan_touxiang7.jpg','security question7','Secret Answer7'),
	 ('2023-03-11 19:58:59','Student account8','123456','Student name8','man','13823888888','440300199808080008','upload/xueyuan_touxiang8.jpg','security question8','Secret Answer8');
INSERT INTO drivingschool.yuyuelianxi (addtime,jiaolianzhanghao,jiaolianxingming,lianxidianhua,xueyuanzhanghao,xueyuanxingming,xueyuanshouji,yuyueshijian,yuyuebeizhu,lianxikemu,sfsh,shhf) VALUES
	 ('2023-03-11 19:58:59','Coach account1','Coach Name1','Contact Number1','Student account1','Student name1','Student mobile phone1','2023-03-11 19:58:59','Appointment remarks1','科目二','是',''),
	 ('2023-03-11 19:58:59','Coach account2','Coach Name2','Contact Number2','Student account2','Student name2','Student mobile phone2','2023-03-11 19:58:59','Appointment remarks2','科目二','是',''),
	 ('2023-03-11 19:58:59','Coach account3','Coach Name3','Contact Number3','Student account3','Student name3','Student mobile phone3','2023-03-11 19:58:59','Appointment remarks3','科目二','是',''),
	 ('2023-03-11 19:58:59','Coach account4','Coach Name4','Contact Number4','Student account4','Student name4','Student mobile phone4','2023-03-11 19:58:59','Appointment remarks4','科目二','是',''),
	 ('2023-03-11 19:58:59','Coach account5','Coach Name5','Contact Number5','Student account5','Student name5','Student mobile phone5','2023-03-11 19:58:59','Appointment remarks5','科目二','是',''),
	 ('2023-03-11 19:58:59','Coach account6','Coach Name6','Contact Number6','Student account6','Student name6','Student mobile phone6','2023-03-11 19:58:59','Appointment remarks6','科目二','是',''),
	 ('2023-03-11 19:58:59','Coach account7','Coach Name7','Contact Number7','Student account7','Student name7','Student mobile phone7','2023-03-11 19:58:59','Appointment remarks7','科目二','是',''),
	 ('2023-03-11 19:58:59','Coach account8','Coach Name8','Contact Number8','Student account8','Student name8','Student mobile phone8','2023-03-11 19:58:59','Appointment remarks8','科目二','是',''),
	 ('2025-03-23 22:13:09','Coach account1','Coach Name1','Contact Number1','Student account1','Student name1','Student mobile phone1','2025-03-23 14:12:57','','科目二','待审核','');
