package mw.glib;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>ブラウザで名前が定義されている全140種類の色を{@link Color}にしてまとめたものです。
 *
 * <p>同じ意味のグレーであるGRAYとGREYがありますが、すべてGRAYで統一します。
 *
 * @author Getaji
 */
public class WebColors {

    /** 黒(#0x000000) */
    public static final Color BLACK = new Color(0x00, 0x00, 0x00);
    /** 薄暗い灰色(#0x696969) */
    public static final Color DIM_GRAY = new Color(0x69, 0x69, 0x69);
    /** 灰色(#0x808080) */
    public static final Color GRAY = new Color(0x80, 0x80, 0x80);
    /** 濃い灰色(#0xA9A9A9) */
    public static final Color DARK_GRAY = new Color(0xA9, 0xA9, 0xA9);
    /** 銀色(#0xC0C0C0) */
    public static final Color SILVER = new Color(0xC0, 0xC0, 0xC0);
    /** 明るい灰色(#0xD3D3D3) */
    public static final Color LIGHT_GRAY = new Color(0xD3, 0xD3, 0xD3);
    /** とても明るい灰色(#0xDCDCDC) */
    public static final Color GAINSBORO = new Color(0xDC, 0xDC, 0xDC);
    /** 白煙色(#0xF5F5F5) */
    public static final Color WHITE_SMOKE = new Color(0xF5, 0xF5, 0xF5);
    /** 白色(#0xFFFFFF) */
    public static final Color WHITE = new Color(0xFF, 0xFF, 0xFF);
    /** 雪色(#0xFFFAFA) */
    public static final Color SNOW = new Color(0xFF, 0xFA, 0xFA);
    /** 幽霊白色(#0xF8F8FF) */
    public static final Color GHOST_WHITE = new Color(0xF8, 0xF8, 0xFF);
    /** 花のような白色(#0xFFFAF0) */
    public static final Color FLORAL_WHITE = new Color(0xFF, 0xFA, 0xF0);
    /** 麻白色(#0xFAF0E6) */
    public static final Color LINEN = new Color(0xFA, 0xF0, 0xE6);
    /** 骨董品のような白色(#0xFAEBD7) */
    public static final Color ANTIQUE_WHITE = new Color(0xFA, 0xEB, 0xD7);
    /** パパイヤのホイップクリーム色(#0xFFEFD5) */
    public static final Color PAPAYA_WHIP = new Color(0xFF, 0xEF, 0xD5);
    /** 湯通ししたアーモンド色(#0xFFEBCD) */
    public static final Color BLANCHED_ALMOND = new Color(0xFF, 0xEB, 0xCD);
    /** ビスク色(#0xFFE4C4) */
    public static final Color BISQUE = new Color(0xFF, 0xE4, 0xC4);
    /** モカシン色(#0xFFE4B5) */
    public static final Color MOCCASIN = new Color(0xFF, 0xE4, 0xB5);
    /** ナバホ白色(#0xFFDEAD) */
    public static final Color NAVAJO_WHITE = new Color(0xFF, 0xDE, 0xAD);
    /** 桃色(#0xFFDAB9) */
    public static final Color PEACH_PUFF = new Color(0xFF, 0xDA, 0xB9);
    /** 霧のような薔薇色(#0xFFE4E1) */
    public static final Color MISTY_ROSE = new Color(0xFF, 0xE4, 0xE1);
    /** ラベンダーの恥じらい色(#0xFFF0F5) */
    public static final Color LAVENDER_BLUSH = new Color(0xFF, 0xF0, 0xF5);
    /** 貝殻色(#0xFFF5EE) */
    public static final Color SEASHELL = new Color(0xFF, 0xF5, 0xEE);
    /** 古いレース色(#0xFDF5E6) */
    public static final Color OLD_LACE = new Color(0xFD, 0xF5, 0xE6);
    /** 象牙色(#0xFFFFF0) */
    public static final Color IVORY = new Color(0xFF, 0xFF, 0xF0);
    /** 甘露色(#0xF0FFF0) */
    public static final Color HONEYDEW = new Color(0xF0, 0xFF, 0xF0);
    /** ミントクリーム色(#0xF5FFFA) */
    public static final Color MINTCREAM = new Color(0xF5, 0xFF, 0xFA);
    /** 紺碧色(#0xF0FFFF) */
    public static final Color AZURE = new Color(0xF0, 0xFF, 0xFF);
    /** アリスブルー色(#0xF0F8FF) */
    public static final Color ALICE_BLUE = new Color(0xF0, 0xF8, 0xFF);
    /** ラベンダー色(#0xE6E6FA) */
    public static final Color LAVENDER = new Color(0xE6, 0xE6, 0xFA);
    /** 明るい青鋼色(#0xB0C4DE) */
    public static final Color LIGHT_STEEL_BLUE = new Color(0xB0, 0xC4, 0xDE);
    /** 明るい灰鋼色(#0x778899) */
    public static final Color LIGHT_SLATE_GRAY = new Color(0x77, 0x88, 0x99);
    /** 灰鋼色(#0x708090) */
    public static final Color SLATE_GRAY = new Color(0x70, 0x80, 0x90);
    /** 青鋼色(#0x4682B4) */
    public static final Color STEEL_BLUE = new Color(0x46, 0x82, 0xB4);
    /** ロイヤルブルー色(#0x4169E1) */
    public static final Color ROYAL_BLUE = new Color(0x41, 0x69, 0xE1);
    /** 真夜中の青色(#0x191970) */
    public static final Color MIDNIGHT_BLUE = new Color(0x19, 0x19, 0x70);
    /** ネイビー色(#0x000080) */
    public static final Color NAVY = new Color(0x00, 0x00, 0x80);
    /** 暗い青色(#0x00008B) */
    public static final Color DARK_BLUE = new Color(0x00, 0x00, 0x8B);
    /** ミディアムブルー色(#0x0000CD) */
    public static final Color MEDIUM_BLUE = new Color(0x00, 0x00, 0xCD);
    /** 青色(#0x0000FF) */
    public static final Color BLUE = new Color(0x00, 0x00, 0xFF);
    /** ペテン師の青色(#0x1E90FF) */
    public static final Color DODGER_BLUE = new Color(0x1E, 0x90, 0xFF);
    /** 矢車菊色(#0x6495ED) */
    public static final Color CORNFLOWER_BLUE = new Color(0x64, 0x95, 0xED);
    /** 深い空色(#0x00BFFF) */
    public static final Color DEEP_SKY_BLUE = new Color(0x00, 0xBF, 0xFF);
    /** 浅い空色(#0x87CEFA) */
    public static final Color LIGHT_SKY_BLUE = new Color(0x87, 0xCE, 0xFA);
    /** 空色(#0x87CEEB) */
    public static final Color SKY_BLUE = new Color(0x87, 0xCE, 0xEB);
    /** 水色(#0xADD8E6) */
    public static final Color LIGHT_BLUE = new Color(0xAD, 0xD8, 0xE6);
    /** 淡青色(#0xB0E0E6) */
    public static final Color POWDER_BLUE = new Color(0xB0, 0xE0, 0xE6);
    /** 淡いトルコ石色(#0xAFEEEE) */
    public static final Color PALE_TURQUOISE = new Color(0xAF, 0xEE, 0xEE);
    /** 明るいシアン色(#0xE0FFFF) */
    public static final Color LIGHT_CYAN = new Color(0xE0, 0xFF, 0xFF);
    /** シアン色(#0x00FFFF) */
    public static final Color CYAN = new Color(0x00, 0xFF, 0xFF);
    /** アクア色(#0x00FFFF) */
    public static final Color AQUA = new Color(0x00, 0xFF, 0xFF);
    /** トルコ石色(#0x40E0D0) */
    public static final Color TURQUOISE = new Color(0x40, 0xE0, 0xD0);
    /** ミディアムターコイズ色(#0x48D1CC) */
    public static final Color MEDIUM_TURQUOISE = new Color(0x48, 0xD1, 0xCC);
    /** 暗いトルコ石色(#0x00CED1) */
    public static final Color DARK_TURQUOISE = new Color(0x00, 0xCE, 0xD1);
    /** 明るい海緑色(#0x20B2AA) */
    public static final Color LIGHT_SEA_GREEN = new Color(0x20, 0xB2, 0xAA);
    /** カデットブルー色(#0x5F9EA0) */
    public static final Color CADET_BLUE = new Color(0x5F, 0x9E, 0xA0);
    /** 暗いシアン色(#0x008B8B) */
    public static final Color DARK_CYAN = new Color(0x00, 0x8B, 0x8B);
    /** 青緑色(#0x008080) */
    public static final Color TEAL = new Color(0x00, 0x80, 0x80);
    /** 暗い粘板岩色(#0x2F4F4F) */
    public static final Color DARK_SLATE_GRAY = new Color(0x2F, 0x4F, 0x4F);
    /** 暗い緑色(#0x006400) */
    public static final Color DARK_GREEN = new Color(0x00, 0x64, 0x00);
    /** 緑色(#0x008000) */
    public static final Color GREEN = new Color(0x00, 0x80, 0x00);
    /** 森の青色(#0x228B22) */
    public static final Color FOREST_GREEN = new Color(0x22, 0x8B, 0x22);
    /** 海緑色(#0x2E8B57) */
    public static final Color SEA_GREEN = new Color(0x2E, 0x8B, 0x57);
    /** ミディアムシーグリーン色(#0x3CB371) */
    public static final Color MEDIUM_SEA_GREEN = new Color(0x3C, 0xB3, 0x71);
    /** ミディアムアクアマリン色(#0x66CDAA) */
    public static final Color MEDIUM_AQUAMARINE = new Color(0x66, 0xCD, 0xAA);
    /** 暗い海緑色(#0x8FBC8F) */
    public static final Color DARK_SEA_GREEN = new Color(0x8F, 0xBC, 0x8F);
    /** アクアマリン色(#0x7FFFD4) */
    public static final Color AQUAMARINE = new Color(0x7F, 0xFF, 0xD4);
    /** 淡緑色(#0x98FB98) */
    public static final Color PALE_GREEN = new Color(0x98, 0xFB, 0x98);
    /** 明るい緑色(#0x90EE90) */
    public static final Color LIGHT_GREEN = new Color(0x90, 0xEE, 0x90);
    /** 新緑色(#0x00FF7F) */
    public static final Color SPRING_GREEN = new Color(0x00, 0xFF, 0x7F);
    /** ミディアムスプリンググリーン色(#0x00FA9A) */
    public static final Color MEDIUM_SPRING_GREEN = new Color(0x00, 0xFA, 0x9A);
    /** 芝生色(#0x7CFC00) */
    public static final Color LAWN_GREEN = new Color(0x7C, 0xFC, 0x00);
    /** シャルトリューズ色(#0x7FFF00) */
    public static final Color CHARTREUSE = new Color(0x7F, 0xFF, 0x00);
    /** 緑黄色(#0xADFF2F) */
    public static final Color GREEN_YELLOW = new Color(0xAD, 0xFF, 0x2F);
    /** ライム色(#0x00FF00) */
    public static final Color LIME = new Color(0x00, 0xFF, 0x00);
    /** ライムグリーン色(#0x32CD32) */
    public static final Color LIME_GREEN = new Color(0x32, 0xCD, 0x32);
    /** 黄緑色(#0x9ACD32) */
    public static final Color YELLOW_GREEN = new Color(0x9A, 0xCD, 0x32);
    /** 暗いオリーブグリーン色(#0x556B2F) */
    public static final Color DARK_OLIVE_GREEN = new Color(0x55, 0x6B, 0x2F);
    /** オリーブドラブ色(#0x6B8E23) */
    public static final Color OLIVE_DRAB = new Color(0x6B, 0x8E, 0x23);
    /** オリーブ色(#0x808000) */
    public static final Color OLIVE = new Color(0x80, 0x80, 0x00);
    /** 暗いカーキ色(#0xBDB76B) */
    public static final Color DARK_KHAKI = new Color(0xBD, 0xB7, 0x6B);
    /** 淡いアキノキリンソウ色(#0xEEE8AA) */
    public static final Color PALE_GOLDENROD = new Color(0xEE, 0xE8, 0xAA);
    /** トウモロコシの毛色(#0xFFF8DC) */
    public static final Color CORN_SILK = new Color(0xFF, 0xF8, 0xDC);
    /** ベージュ色(#0xF5F5DC) */
    public static final Color BEIGE = new Color(0xF5, 0xF5, 0xDC);
    /** 明るい黄色(#0xFFFFE0) */
    public static final Color LIGHT_YELLOW = new Color(0xFF, 0xFF, 0xE0);
    /** 明るいアキノキリンソウ色(#0xFAFAD2) */
    public static final Color LIGHT_GOLDENROD_YELLOW = new Color(0xFA, 0xFA, 0xD2);
    /** 山鳩色(#0xFFFACD) */
    public static final Color LEMON_CHIFFON = new Color(0xFF, 0xFA, 0xCD);
    /** 麦色(#0xF5DEB3) */
    public static final Color WHEAT = new Color(0xF5, 0xDE, 0xB3);
    /** 大木色(#0xDEB887) */
    public static final Color BURLY_WOOD = new Color(0xDE, 0xB8, 0x87);
    /** 日焼け色(#0xD2B48C) */
    public static final Color TAN = new Color(0xD2, 0xB4, 0x8C);
    /** カーキ色(#0xF0E68C) */
    public static final Color KHAKI = new Color(0xF0, 0xE6, 0x8C);
    /** 黄色(#0xFFFF00) */
    public static final Color YELLOW = new Color(0xFF, 0xFF, 0x00);
    /** 金色(#0xFFD700) */
    public static final Color GOLD = new Color(0xFF, 0xD7, 0x00);
    /** 橙色(#0xFFA500) */
    public static final Color ORANGE = new Color(0xFF, 0xA5, 0x00);
    /** 砂茶色(#0xF4A460) */
    public static final Color SANDY_BROWN = new Color(0xF4, 0xA4, 0x60);
    /** 暗い橙色(#0xFF8C00) */
    public static final Color DARK_ORANGE = new Color(0xFF, 0x8C, 0x00);
    /** アキノキリンソウ色(#0xDAA520) */
    public static final Color GOLDENROD = new Color(0xDA, 0xA5, 0x20);
    /** ペルー色(#0xCD853F) */
    public static final Color PERU = new Color(0xCD, 0x85, 0x3F);
    /** 暗いアキノキリンソウ色(#0xB8860B) */
    public static final Color DARK_GOLDENROD = new Color(0xB8, 0x86, 0x0B);
    /** チョコレート色(#0xD2691E) */
    public static final Color CHOCOLATE = new Color(0xD2, 0x69, 0x1E);
    /** シエナ色(#0xA0522D) */
    public static final Color SIENNA = new Color(0xA0, 0x52, 0x2D);
    /** 馬鞍色(#0x8B4513) */
    public static final Color SADDLEBROWN = new Color(0x8B, 0x45, 0x13);
    /** 栗色(#0x800000) */
    public static final Color MAROON = new Color(0x80, 0x00, 0x00);
    /** 暗い赤色(#0x8B0000) */
    public static final Color DARK_RED = new Color(0x8B, 0x00, 0x00);
    /** 茶色(#0xA52A2A) */
    public static final Color BROWN = new Color(0xA5, 0x2A, 0x2A);
    /** 耐火レンガ色(#0xB22222) */
    public static final Color FIREBRICK = new Color(0xB2, 0x22, 0x22);
    /** インディアンレッド色(#0xCD5C5C) */
    public static final Color INDIAN_RED = new Color(0xCD, 0x5C, 0x5C);
    /** 薔薇茶色(#0xBC8F8F) */
    public static final Color ROSY_BROWN = new Color(0xBC, 0x8F, 0x8F);
    /** 暗い鮭色(#0xE9967A) */
    public static final Color DARK_SALMON = new Color(0xE9, 0x96, 0x7A);
    /** 明るい珊瑚色(#0xF08080) */
    public static final Color LIGHT_CORAL = new Color(0xF0, 0x80, 0x80);
    /** 鮭色(#0xFA8072) */
    public static final Color SALMON = new Color(0xFA, 0x80, 0x72);
    /** 明るい鮭色(#0xFFA07A) */
    public static final Color LIGHT_SALMON = new Color(0xFF, 0xA0, 0x7A);
    /** 珊瑚色(#0xFF7F50) */
    public static final Color CORAL = new Color(0xFF, 0x7F, 0x50);
    /** トマト色(#0xFF6347) */
    public static final Color TOMATO = new Color(0xFF, 0x63, 0x47);
    /** 赤橙色(#0xFF4500) */
    public static final Color ORANGE_RED = new Color(0xFF, 0x45, 0x00);
    /** 赤色(#0xFF0000) */
    public static final Color RED = new Color(0xFF, 0x00, 0x00);
    /** 茜色(#0xDC143C) */
    public static final Color CRIMSON = new Color(0xDC, 0x14, 0x3C);
    /** ミディアムバイオレットレッド色(#0xC71585) */
    public static final Color MEDIUM_VIOLET_RED = new Color(0xC7, 0x15, 0x85);
    /** 濃いピンク色(#0xFF1493) */
    public static final Color DEEPPINK = new Color(0xFF, 0x14, 0x93);
    /** ショッキングピンク色(#0xFF69B4) */
    public static final Color HOTPINK = new Color(0xFF, 0x69, 0xB4);
    /** 淡いすみれ色(#0xDB7093) */
    public static final Color PALE_VIOLET_RED = new Color(0xDB, 0x70, 0x93);
    /** ピンク色(#0xFFC0CB) */
    public static final Color PINK = new Color(0xFF, 0xC0, 0xCB);
    /** 明るいピンク色(#0xFFB6C1) */
    public static final Color LIGHT_PINK = new Color(0xFF, 0xB6, 0xC1);
    /** アザミ色(#0xD8BFD8) */
    public static final Color THISTLE = new Color(0xD8, 0xBF, 0xD8);
    /** マゼンタ色(#0xFF00FF) */
    public static final Color MAGENTA = new Color(0xFF, 0x00, 0xFF);
    /** フクシャ色(#0xFF00FF) */
    public static final Color FUCHSIA = new Color(0xFF, 0x00, 0xFF);
    /** すみれ色(#0xEE82EE) */
    public static final Color VIOLET = new Color(0xEE, 0x82, 0xEE);
    /** プラム色(#0xDDA0DD) */
    public static final Color PLUM = new Color(0xDD, 0xA0, 0xDD);
    /** 蘭色(#0xDA70D6) */
    public static final Color ORCHID = new Color(0xDA, 0x70, 0xD6);
    /** ミディアムオーキッド色(#0xBA55D3) */
    public static final Color MEDIUM_ORCHID = new Color(0xBA, 0x55, 0xD3);
    /** 暗い蘭色(#0x9932CC) */
    public static final Color DARK_ORCHID = new Color(0x99, 0x32, 0xCC);
    /** 暗いすみれ色(#0x9400D3) */
    public static final Color DARK_VIOLET = new Color(0x94, 0x00, 0xD3);
    /** 暗いマゼンタ色(#0x8B008B) */
    public static final Color DARK_MAGENTA = new Color(0x8B, 0x00, 0x8B);
    /** 紫色(#0x800080) */
    public static final Color PURPLE = new Color(0x80, 0x00, 0x80);
    /** 藍色(#0x4B0082) */
    public static final Color INDIGO = new Color(0x4B, 0x00, 0x82);
    /** 暗い青鋼色(#0x483D8B) */
    public static final Color DARK_SLATE_BLUE = new Color(0x48, 0x3D, 0x8B);
    /** 青すみれ色(#0x8A2BE2) */
    public static final Color BLUE_VIOLET = new Color(0x8A, 0x2B, 0xE2);
    /** ミディアムパープル色(#0x9370DB) */
    public static final Color MEDIUM_PURPLE = new Color(0x93, 0x70, 0xDB);
    /** 青鋼色(#0x6A5ACD) */
    public static final Color SLATE_BLUE = new Color(0x6A, 0x5A, 0xCD);
    /** ミディアムスレートブルー色(#0x7B68EE) */
    public static final Color MEDIUM_SLATE_BLUE = new Color(0x7B, 0x68, 0xEE);

    private static final Map<String, Color> colorNameMap = new HashMap<>();

    static {
        for (Field field : WebColors.class.getFields()) {
            if (field.getType().equals(Color.class)) {
                String name = field.getName().replace("_", "").toLowerCase();
                try {
                    colorNameMap.put(name, (Color) field.get(Color.class));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private WebColors() {}

    /**
     * 色名から、保持する色を返します。指定された色名は小文字として扱われます。
     *
     * @param colorName 色名
     * @return 対応した色
     */
    public static Color nameOf(String colorName) {
        Checker.requireNonEmpty(colorName);
        return colorNameMap.get(colorName);
    }

    /**
     * 色名と色をペアで保持するHashMapを返します。
     *
     * @return 色マップ
     */
    public static Map<String, Color> getColorNameMap() {
        return colorNameMap;
    }
}
