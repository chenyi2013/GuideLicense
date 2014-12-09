package com.puji.guidelicense;

import java.util.ArrayList;

public class DataSource {

	public static final int FLOOR_5 = 1;
	public static final int FLOOR_5_2 = 4;
	public static final int FLOOR_11 = 2;
	public static final int FLOOR_11_2 = 3;
	public static final int FLOOR_4 = 5;

	public static ArrayList<Floor> getF5Data() {
		ArrayList<Floor> floors = new ArrayList<Floor>();
		Floor f5 = new Floor();
		f5.setFloorName("F5");
		f5.setTag("影院\t儿童");
		f5.setShops("UME国际影城       大食代    柏斯琴行   灰姑娘芭蕾\n迈格森国际教育   七田真    疯狂钢琴   真朴围棋");
		floors.add(f5);

		Floor f4 = new Floor();
		f4.setFloorName("F4");
		f4.setTag("时尚休闲\t儿童乐园");
		f4.setShops("流行服装服饰   儿童专区   UME影城DMA影厅（10号厅）\n爱乐国际早教   红黄蓝       多弗兰格葡式洗西餐    麻辣诱惑");
		floors.add(f4);

		Floor f3 = new Floor();
		f3.setFloorName("F3");
		f3.setTag("时尚休闲\t特色餐饮");
		f3.setShops("流行服装服饰       运动休闲    中国黄金    全城热恋钻石\n汉拿山石锅拌饭   金汤玉线    恭喜恭喜    缔旺茶餐厅\n川成元麻辣香锅   味干拉面    禾绿寿司    红卡咖啡\n滇草香");
		floors.add(f3);

		Floor f2 = new Floor();
		f2.setFloorName("F2");
		f2.setTag("时尚名媛");
		f2.setShops("流行服装服饰     美容护理\n必胜客");
		floors.add(f2);

		Floor f1 = new Floor();
		f1.setFloorName("F1");
		f1.setTag("时尚精品");
		f1.setShops("国际服装服饰    风尚品牌\n星巴客                哈根达斯");
		floors.add(f1);

		Floor b1 = new Floor();
		b1.setFloorName("B1");
		b1.setTag("潮流前线\t美食广场");
		b1.setShops("潮流品牌    blt超市\n呷哺呷哺   满记甜品   麦当劳   肯德基\n地铁十号线A出口");
		floors.add(b1);

		return floors;

	}

	public static ArrayList<Floor> getF5_2Data() {
		ArrayList<Floor> floors = new ArrayList<Floor>();

		Floor f5 = new Floor();
		f5.setFloorName("F5");
		f5.setTag("影院\t儿童");
		f5.setShops("UME国际影城       大食代    柏斯琴行   灰姑娘芭蕾\n迈格森国际教育   七田真    疯狂钢琴   真朴围棋");
		floors.add(f5);

		Floor f4 = new Floor();
		f4.setFloorName("F4");
		f4.setTag("时尚休闲\t儿童乐园");
		f4.setShops("流行服装服饰   儿童专区   UME影城DMA影厅（10号厅）\n爱乐国际早教   红黄蓝       多弗兰格葡式洗西餐    麻辣诱惑");
		floors.add(f4);

		Floor f3 = new Floor();
		f3.setFloorName("F3");
		f3.setTag("时尚休闲\t特色餐饮");
		f3.setShops("流行服装服饰       运动休闲    中国黄金    全城热恋钻石\n汉拿山石锅拌饭   金汤玉线    恭喜恭喜    缔旺茶餐厅\n川成元麻辣香锅   味干拉面    禾绿寿司    红卡咖啡\n滇草香");
		floors.add(f3);

		Floor f2 = new Floor();
		f2.setFloorName("F2");
		f2.setTag("时尚名媛");
		f2.setShops("流行服装服饰     美容护理\n必胜客");
		floors.add(f2);

		Floor f1 = new Floor();
		f1.setFloorName("F1");
		f1.setTag("时尚精品");
		f1.setShops("国际服装服饰    风尚品牌\n星巴客                哈根达斯");
		floors.add(f1);

		Floor b1 = new Floor();
		b1.setFloorName("B1");
		b1.setTag("潮流前线\t美食广场");
		b1.setShops("潮流品牌    blt超市\n呷哺呷哺   满记甜品   麦当劳   肯德基\n地铁十号线A出口");
		floors.add(b1);

		Floor b2 = new Floor();
		b2.setFloorName("B2");
		b2.setTag("");
		b2.setShops("停车场");
		floors.add(b2);

		Floor b3 = new Floor();
		b3.setFloorName("B3");
		b3.setTag("");
		b3.setShops("停车场");
		floors.add(b3);

		return floors;

	}

	public static ArrayList<Floor> getF4Data() {
		ArrayList<Floor> floors = new ArrayList<Floor>();

		Floor f4 = new Floor();
		f4.setFloorName("F4");
		f4.setTag("时尚休闲\t儿童乐园");
		f4.setShops("流行服装服饰   儿童专区   UME影城DMA影厅（10号厅）\n爱乐国际早教   红黄蓝       多弗兰格葡式洗西餐    麻辣诱惑");
		floors.add(f4);

		Floor f3 = new Floor();
		f3.setFloorName("F3");
		f3.setTag("时尚休闲\t特色餐饮");
		f3.setShops("流行服装服饰       运动休闲    中国黄金    全城热恋钻石\n汉拿山石锅拌饭   金汤玉线    恭喜恭喜    缔旺茶餐厅\n川成元麻辣香锅   味干拉面    禾绿寿司    红卡咖啡\n滇草香");
		floors.add(f3);

		Floor f2 = new Floor();
		f2.setFloorName("F2");
		f2.setTag("时尚名媛");
		f2.setShops("流行服装服饰     美容护理\n必胜客");
		floors.add(f2);

		Floor f1 = new Floor();
		f1.setFloorName("F1");
		f1.setTag("时尚精品");
		f1.setShops("国际服装服饰    风尚品牌\n星巴客                哈根达斯");
		floors.add(f1);

		Floor b1 = new Floor();
		b1.setFloorName("B1");
		b1.setTag("潮流前线\t美食广场");
		b1.setShops("潮流品牌    blt超市\n呷哺呷哺   满记甜品   麦当劳   肯德基\n地铁十号线A出口");
		floors.add(b1);

		Floor b2 = new Floor();
		b2.setFloorName("B2");
		b2.setTag("");
		b2.setShops("停车场");
		floors.add(b2);

		Floor b3 = new Floor();
		b3.setFloorName("B3");
		b3.setTag("");
		b3.setShops("停车场");
		floors.add(b3);

		return floors;

	}

	public static ArrayList<Floor> getF11Data() {
		ArrayList<Floor> floors = new ArrayList<Floor>();

		Floor f11 = new Floor();
		f11.setFloorName("F11");
		f11.setTag("");
		f11.setShops("多佐KTV");
		floors.add(f11);

		Floor f10 = new Floor();
		f10.setFloorName("F10");
		f10.setTag("");
		f10.setShops("多佐KTV");
		floors.add(f10);

		Floor f9 = new Floor();
		f9.setFloorName("F9");
		f9.setTag("");
		f9.setShops("多佐精致料理");
		floors.add(f9);

		Floor f8 = new Floor();
		f8.setFloorName("F8");
		f8.setTag("");
		f8.setShops("汉拿山韩式烤肉");
		floors.add(f8);

		Floor f7 = new Floor();
		f7.setFloorName("F7");
		f7.setTag("");
		f7.setShops("港丽餐厅");
		floors.add(f7);

		Floor f6 = new Floor();
		f6.setFloorName("F6");
		f6.setTag("");
		f6.setShops("UME影城");
		floors.add(f6);

		Floor f5 = new Floor();
		f5.setFloorName("F5");
		f5.setTag("影院\t儿童");
		f5.setShops("UME国际影城       大食代    柏斯琴行   灰姑娘芭蕾\n迈格森国际教育   七田真    疯狂钢琴   真朴围棋");
		floors.add(f5);

		Floor f4 = new Floor();
		f4.setFloorName("F4");
		f4.setTag("时尚休闲\t儿童乐园");
		f4.setShops("流行服装服饰   儿童专区   UME影城DMA影厅（10号厅）\n爱乐国际早教   红黄蓝       多弗兰格葡式洗西餐    麻辣诱惑");
		floors.add(f4);

		Floor f3 = new Floor();
		f3.setFloorName("F3");
		f3.setTag("时尚休闲\t特色餐饮");
		f3.setShops("流行服装服饰       运动休闲    中国黄金    全城热恋钻石\n汉拿山石锅拌饭   金汤玉线    恭喜恭喜    缔旺茶餐厅\n川成元麻辣香锅   味干拉面    禾绿寿司    红卡咖啡\n滇草香");
		floors.add(f3);

		Floor f2 = new Floor();
		f2.setFloorName("F2");
		f2.setTag("时尚名媛");
		f2.setShops("流行服装服饰     美容护理\n必胜客");
		floors.add(f2);

		Floor f1 = new Floor();
		f1.setFloorName("F1");
		f1.setTag("时尚精品");
		f1.setShops("国际服装服饰    风尚品牌\n星巴客                哈根达斯");
		floors.add(f1);

		Floor b1 = new Floor();
		b1.setFloorName("B1");
		b1.setTag("潮流前线\t美食广场");
		b1.setShops("潮流品牌    blt超市\n呷哺呷哺   满记甜品   麦当劳   肯德基\n地铁十号线A出口");
		floors.add(b1);

		Floor b2 = new Floor();
		b2.setFloorName("B2");
		b2.setTag("");
		b2.setShops("停车场");
		floors.add(b2);

		Floor b3 = new Floor();
		b3.setFloorName("B3");
		b3.setTag("");
		b3.setShops("停车场");
		floors.add(b3);

		return floors;

	}

	public static ArrayList<Floor> getF11_2Data() {
		ArrayList<Floor> floors = new ArrayList<Floor>();

		Floor f11 = new Floor();
		f11.setFloorName("F11");
		f11.setTag("");
		f11.setShops("多佐KTV");
		floors.add(f11);

		Floor f10 = new Floor();
		f10.setFloorName("F10");
		f10.setTag("");
		f10.setShops("多佐KTV");
		floors.add(f10);

		Floor f9 = new Floor();
		f9.setFloorName("F9");
		f9.setTag("");
		f9.setShops("多佐精致料理");
		floors.add(f9);

		Floor f8 = new Floor();
		f8.setFloorName("F8");
		f8.setTag("");
		f8.setShops("汉拿山韩式烤肉");
		floors.add(f8);

		Floor f7 = new Floor();
		f7.setFloorName("F7");
		f7.setTag("");
		f7.setShops("港丽餐厅");
		floors.add(f7);

		Floor f6 = new Floor();
		f6.setFloorName("F6");
		f6.setTag("");
		f6.setShops("UME影城");
		floors.add(f6);

		Floor f1 = new Floor();
		f1.setFloorName("F1");
		f1.setTag("时尚精品");
		f1.setShops("国际服装服饰    风尚品牌\n星巴客                哈根达斯");
		floors.add(f1);

		Floor b1 = new Floor();
		b1.setFloorName("B1");
		b1.setTag("潮流前线\t美食广场");
		b1.setShops("潮流品牌    blt超市\n呷哺呷哺   满记甜品   麦当劳   肯德基\n地铁十号线A出口");
		floors.add(b1);

		Floor b2 = new Floor();
		b2.setFloorName("B2");
		b2.setTag("");
		b2.setShops("停车场");
		floors.add(b2);

		Floor b3 = new Floor();
		b3.setFloorName("B3");
		b3.setTag("");
		b3.setShops("停车场");
		floors.add(b3);

		return floors;

	}
}
