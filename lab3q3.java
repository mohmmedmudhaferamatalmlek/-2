

package com.mycompany.lab3q3;
public class lab3q3 {
    public static String caesarEncrypt(String text, int shift, String language) {
        StringBuilder encryptedText = new StringBuilder();
        int alphabetSize;
        char base;

        // تحديد اللغة وضبط القيم المناسبة
        switch (language.toLowerCase()) {
            case "greek":
                alphabetSize = 24;
                break;
            case "russian":
                alphabetSize = 33;
                break;
            case "hebrew":
                alphabetSize = 22;
                break;
            default:
                alphabetSize = 26; // اللغة الإنجليزية افتراضيًا
        }

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (language.equals("hebrew")) {
                    base = 'א'; // لا يوجد فرق بين الأحرف الكبيرة والصغيرة
                } else {
                    base = Character.isUpperCase(ch) ? ch : ch; // استخدام الحرف كما هو
                }

                char encryptedChar = (char) ((ch - base + shift) % alphabetSize + base);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(ch); // الاحتفاظ بالرموز دون تغيير
            }
        }
        return encryptedText.toString();
    }

    public static void main(String[] args) {
        String text = "Привет мир"; // رسالة روسية تعني "مرحبا بالعالم"
        int shift = 3;
        String encrypted = caesarEncrypt(text, shift, "russian");
        System.out.println("النص المشفر: " + encrypted);
    }
}
