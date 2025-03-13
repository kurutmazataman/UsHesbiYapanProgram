### Adım Adım İşleyişi:

1. **Kullanıcıdan Girdi Alma:**
    - Program, kullanıcıdan iki adet sayı alır: **taban sayısı** ve **tavan sayısı**.
    - Taban sayısı, üssü alınacak sayıyı belirtirken, tavan sayısı, hangi üssü hesaplamak istediğimizi belirtir.

2. **Üs Hesaplaması:**
    - Kullanıcıdan alınan sayılar `recursivePow` metoduna gönderilir.
    - `recursivePow` metodu **rekürsif** olarak çalışır. Yani, üs değeri sıfır olana kadar kendisini tekrar çağırarak üssü hesaplar.

3. **Hata Yönetimi:**
    - Programda, kullanıcı hatalı veri girişi yaparsa (`InputMismatchException`), veya başka bir hata meydana gelirse (`Exception`), bu hatalar yakalanır ve kullanıcıya uygun hata mesajları verilir.
    - `finally` bloğunda `Scanner` nesnesi kapatılır.

### Detaylı Açıklama:

#### 1. Kullanıcıdan Girdi Alma:
```java
System.out.print("Lutfen taban sayisini giriniz: ");
byte floorNumb = scn.nextByte();  // Taban sayısı alınır

System.out.print("Lutfen tavan sayisini giriniz: ");
byte powNumb = scn.nextByte();  // Tavan sayısı alınır
```
- Burada kullanıcıdan iki tane `byte` türünde sayılar alınır: biri taban sayısı (`floorNumb`) ve diğeri ise üssü belirtilen sayıdır (`powNumb`).

#### 2. Rekürsif Üs Hesaplama:
```java
public static double recursivePow(int floorNumb, int powNumb) {
            if (powNumb == 0) {
            return 1;
        } else {
            return floorNumb * recursivePow(floorNumb, powNumb - 1);
        }
}
```
- Bu metot, üs hesaplamak için rekürsiyon kullanır. `powNumb == 0` olduğunda, üs sıfır olduğu için sonuç 1 döndürülür (her sayının sıfırıncı kuvveti 1'dir).
- Eğer `powNumb` sıfır değilse, taban sayısı (`floorNumb`) ile `powNumb`'in bir eksiği olan değeri için `recursivePow` tekrar çağrılır. Bu sayede üs birer birer azaltılır ve sonunda üs sıfır olduğunda sonuca ulaşılır.

#### 3. Hata Yönetimi:
- **`InputMismatchException`**: Kullanıcı geçerli bir sayı girmezse (örneğin, bir harf girerse), hata mesajı olarak "Hatali veri girişi" gösterilir.
- **`NullPointerException`**: Nadir bir durum, ama burada bir `NullPointerException` yakalanması durumunda "Nesne oluşturulamadı !" mesajı gösterilir.
- **`Exception`**: Diğer tüm hatalar için genel bir hata mesajı gösterilir.

#### 4. `finally` Bloku:
```java
finally {
    scn.close();
}
```
- `Scanner` nesnesi, giriş alma işlemi bitince kapatılır.

### Örnek:
Eğer kullanıcı şu şekilde bir girdi yaparsa:
```
Lutfen taban sayisini giriniz: 2
Lutfen tavan sayisini giriniz: 3
```
Program şu sonucu hesaplar:
```
Sonuc: 8.0
```
Çünkü `2^3 = 2 * 2 * 2 = 8`.

### Özet:
Bu program, kullanıcıdan iki sayı alıp ilk sayının ikinci sayıya üssünü hesaplayan bir uygulamadır. Üssü hesaplamak için rekürsif bir fonksiyon kullanır. Ayrıca, giriş hatalarını uygun şekilde yakalar ve kullanıcıya açıklayıcı hata mesajları verir.
