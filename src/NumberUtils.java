class NumberUtils {

    public enum RomanNumeral {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);

        private final int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }


    }

    public static boolean isRomanNumeral(String s) {
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) == 'I' || s.charAt(i) == 'V' || s.charAt(i) == 'X' || s.charAt(i) == 'L' || s.charAt(i) == 'C' || s.charAt(i) == 'D' || s.charAt(i) == 'M')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isArabicNumeral(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static int romanToArabic(String s) {
        s = s.toUpperCase();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V' || s.charAt(i) == 'I' && s.charAt(i + 1) == 'X' || s.charAt(i) == 'X' && s.charAt(i + 1) == 'L' || s.charAt(i) == 'C' && s.charAt(i + 1) == 'D' || s.charAt(i) == 'C' && s.charAt(i + 1) == 'M')) {
                sum -= RomanNumeral.valueOf(s.substring(i, i + 2)).getValue();
                i++;
            } else {
                sum += RomanNumeral.valueOf(String.valueOf(s.charAt(i))).getValue();
            }
        }
        return sum;
    }


    public static String arabicToRoman(int arabic) {
        String roman = "";
        if (arabic > 0) {
            while (arabic > 0) {
                if (arabic >= RomanNumeral.M.getValue()) {
                    roman += RomanNumeral.M.name();
                    arabic -= RomanNumeral.M.getValue();
                } else if (arabic >= RomanNumeral.CM.getValue()) {
                    roman += RomanNumeral.CM.name();
                    arabic -= RomanNumeral.CM.getValue();
                } else if (arabic >= RomanNumeral.D.getValue()) {
                    roman += RomanNumeral.D.name();
                    arabic -= RomanNumeral.D.getValue();
                } else if (arabic >= RomanNumeral.CD.getValue()) {
                    roman += RomanNumeral.CD.name();
                    arabic -= RomanNumeral.CD.getValue();
                } else if (arabic >= RomanNumeral.C.getValue()) {
                    roman += RomanNumeral.C.name();
                    arabic -= RomanNumeral.C.getValue();
                } else if (arabic >= RomanNumeral.XC.getValue()) {
                    roman += RomanNumeral.XC.name();
                    arabic -= RomanNumeral.XC.getValue();
                } else if (arabic >= RomanNumeral.L.getValue()) {
                    roman += RomanNumeral.L.name();
                    arabic -= RomanNumeral.L.getValue();
                } else if (arabic >= RomanNumeral.XL.getValue()) {
                    roman += RomanNumeral.XL.name();
                    arabic -= RomanNumeral.XL.getValue();
                } else if (arabic >= RomanNumeral.X.getValue()) {
                    roman += RomanNumeral.X.name();
                    arabic -= RomanNumeral.X.getValue();
                } else if (arabic >= RomanNumeral.IX.getValue()) {
                    roman += RomanNumeral.IX.name();
                    arabic -= RomanNumeral.IX.getValue();
                } else if (arabic >= RomanNumeral.V.getValue()) {
                    roman += RomanNumeral.V.name();
                    arabic -= RomanNumeral.V.getValue();
                } else if (arabic >= RomanNumeral.IV.getValue()) {
                    roman += RomanNumeral.IV.name();
                    arabic -= RomanNumeral.IV.getValue();
                } else if (arabic >= RomanNumeral.I.getValue()) {
                    roman += RomanNumeral.I.name();
                    arabic -= RomanNumeral.I.getValue();
                }
            }
            return roman;
        }
        throw new IllegalArgumentException("Invalid arabic number");
    }


    public static String sumRomanNumbers(String s1, String s2) {
        int arabic1 = romanToArabic(s1);
        int arabic2 = romanToArabic(s2);
        return arabicToRoman(arabic1 + arabic2);
    }

    public static String subtractRomanNumbers(String s1, String s2) {
        int arabic1 = romanToArabic(s1);
        int arabic2 = romanToArabic(s2);
        if (arabic1 < arabic2) {
            throw new IllegalArgumentException("Invalid subtraction");
        }
        return arabicToRoman(arabic1 - arabic2);
    }

    public static String multiplyRomanNumbers(String s1, String s2) {
        int arabic1 = romanToArabic(s1);
        int arabic2 = romanToArabic(s2);
        return arabicToRoman(arabic1 * arabic2);
    }

    public static String divideRomanNumbers(String s1, String s2) {
        int arabic1 = romanToArabic(s1);
        int arabic2 = romanToArabic(s2);
        if (arabic2 == 0) {
            throw new IllegalArgumentException("Invalid division");
        }
        return arabicToRoman(arabic1 / arabic2);
    }

    public static int sumArabicNumbers(String s1, String s2) {
        int arabic1 = Integer.parseInt(s1);
        int arabic2 = Integer.parseInt(s2);
        return arabic1 + arabic2;
    }

    public static int subtractArabicNumbers(String s1, String s2) {
        int arabic1 = Integer.parseInt(s1);
        int arabic2 = Integer.parseInt(s2);
        return arabic1 - arabic2;
    }

    public static int multiplyArabicNumbers(String s1, String s2) {
        int arabic1 = Integer.parseInt(s1);
        int arabic2 = Integer.parseInt(s2);
        return arabic1 * arabic2;
    }


    public static int divideArabicNumbers(String s1, String s2) {
        if (Integer.parseInt(s2) == 0) {
            throw new IllegalArgumentException("Invalid arabic number");
        }
        int arabic1 = Integer.parseInt(s1);
        int arabic2 = Integer.parseInt(s2);
        return arabic1 / arabic2;
    }
}
