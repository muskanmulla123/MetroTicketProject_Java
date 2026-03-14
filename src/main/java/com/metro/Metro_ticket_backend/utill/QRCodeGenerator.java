package com.metro.Metro_ticket_backend.utill;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class QRCodeGenerator {

    public static String generateQRCode(String text) {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            var bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 200, 200);

            BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < 200; x++) {
                for (int y = 0; y < 200; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
                }
            }

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", stream);

            return Base64.getEncoder().encodeToString(stream.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException("QR Code generation failed");
        }
    }
}