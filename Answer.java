public class Answer {
    2) Fıkra ve hikaye türündeki kitapların adını ve türünü listeleyin.
            select * from kitap as k , tur as t where k.turno = t.turno and t.turadi in('Fıkra,Hikaye')


3) 10B veya 10C sınıfındaki öğrencilerin numarasını, adını, soyadını ve okuduğu kitapları listeleyin.
    select * from ogrenci as o,islem as i,kitap as k
    where o.ogrno = i.ogrno and i.kitapno = k.kitapno
    and sinif in ('10A','10B')

            #join ile yazın
4) Öğrencinin adını, soyadını ve kitap aldığı tarihleri listeleyin.
    select o.ograd,o.ogrsoyad,i.atarih from ogrenci as o
    inner join islem as i on o.ogrno = i.ogrno order by o.ograd ,o.ogrsoyad asc



5) Fıkra ve hikaye türündeki kitapların adını ve türünü listeleyin.
    select k.kitapadi , t.turadi from kitap as k
    inner join tur as t on k.turno=k.turno
    where t.turadi in ('Fıkra', 'Hikaye')

6) 10B veya 10C sınıfındaki öğrencilerin numarasını, adını, soyadını ve okuduğu kitapları, öğrenci adına göre listeleyin.
    select o.ogrno ,o.ograd,o.ogrsoyad,k.kitapadi from ogrenci as o,
    inner join islem as i on o.ogrno=i.ogrno
    inner join kitap as k on k.kitapno = i.kitapno
    where o.sinif in ('10B' ,'10C' )
    order by o.ograd

            7) Kitap alan öğrencinin adı, soyadı, kitap aldığı tarih listelensin. Kitap almayan öğrencilerinde listede görünsün.



8) Kitap almayan öğrencileri listeleyin.
    select o.ograd, o.ogrsoyad , i.atarih from ogrenci as o
    letf join islem as i on o.ogrno = i.ogrno

            9) Alınan kitapların kitap numarasını, adını ve kaç defa alındığını kitap numaralarına göre artan sırada listeleyiniz.
    select k.kitapadi ,kitapno  count(k.kitapno) from kitap as k
    inner join islem as i on k.kitapno = i.kitapno
    group by k.kitapadi , kitapno
    order by k.kitapno

            10) Alınan kitapların kitap numarasını, adını kaç defa alındığını (alınmayan kitapların yanında 0 olsun) listeleyin.
    select k.kitapadi ,kitapno  count(k.kitapno)  as adet from kitap as k
    left join islem as i on k.kitapno = i.kitapno
    group by k.kitapadi , k.kitapno
    order by adet asc


            11) Öğrencilerin adı soyadı ve aldıkları kitabın adı listelensin.
    select o.ograd , o.ogrsoyad, k.kitapadi from ogrenci as o
    inner join islem as i on o.ogrno = i.ogrno
    inner join kitap as k on k.kitapno=i.kitapno
    order by o.ograd , o.ogrsoyad asc

            12) Her öğrencinin adı, soyadı, kitabın adı, yazarın adı soyad ve kitabın türünü ve kitabın alındığı tarihi listeleyiniz. Kitap almayan öğrenciler de listede görünsün.

    select o.ograd , o.ogrsoyad, k.kitapadi ,y.yazarad,y.yazarsoyad,i.atarih,t.turadi from ogrenci as o
    left join islem as i on o.ogrno = i.ogrno
    left join kitap as k on k.kitapno=i.kitapno
    left join yazar as y on k.yazarno = y.yazarno
    left join tur as t on k.turno=t.turno
    order by o.ograd , o.ogrsoyad asc
            13) 10A veya 10B sınıfındaki öğrencilerin adı soyadı ve okuduğu kitap sayısını getirin.
    select  o.ograd,o.ogrsoyad count(o.ogrno)  from ogrenci as o
    inner join islem as i on o.ogrno=i.ogrno
    where o.sinif in ('10A' ,'10B' )
    group by o.ograd,ogrsoyad


            14) Tüm kitapların ortalama sayfa sayısını bulunuz.
            #AVG
    select avg (sayfasayisi) as ortalama_sayfasayisi from kitap


15) Sayfa sayısı ortalama sayfanın üzerindeki kitapları listeleyin.
    select k.kitapadi ,k.sayfasayisi from kitap  as k where sayfasayisi > (select avg (sayfasayisi) from kitap)


16) Öğrenci tablosundaki öğrenci sayısını gösterin
    select count(o.ogrno) from ogrenci as o

17) Öğrenci tablosundaki toplam öğrenci sayısını toplam sayı takma(alias kullanımı) adı ile listeleyin.
    select count(o.ogrno)  as 'toplam_sayi' from  ogrenci as o

            18) Öğrenci tablosunda kaç farklı isimde öğrenci olduğunu listeleyiniz.
    select  count(discont(o.ograd))  as 'toplam_sayi' from  ogrenci as o

            19) En fazla sayfa sayısı olan kitabın sayfa sayısını listeleyiniz.
            select max(k.sayfasayisi) from kitap as k

20) En fazla sayfası olan kitabın adını ve sayfa sayısını listeleyiniz.
    select kitapadi , sayfasayisi from kitap where sayfasayisi= (select max(sayfasayisi) from kitap )

            21) En az sayfa sayısı olan kitabın sayfa sayısını listeleyiniz.
            select min(k.sayfasayisi) from kitap as k

22) En az sayfası olan kitabın adını ve sayfa sayısını listeleyiniz.
    select kitapadi , sayfasayisi from kitap where sayfasayisi= (select min(sayfasayisi) from kitap )


            23) Dram türündeki en fazla sayfası olan kitabın sayfa sayısını bulunuz.
    select max(sayfasayisi) from kitap as k
    inner join tur as t on k.turno=t.turno
    where t.turadi = 'Dram'

            24) numarası 15 olan öğrencinin okuduğu toplam sayfa sayısını bulunuz.
            select sum(sayfasayisi) from islem as i
    inner join kitap as k on i.kitapno=k.kitapno
    where i.ogrno=15

25) İsme göre öğrenci sayılarının adedini bulunuz.(Örn: ali 5 tane, ahmet 8 tane )
    select o.ograd, count(*) as adet from ogrenci as o group by o.ograd
    order by  adet asc

            26) Her sınıftaki öğrenci sayısını bulunuz.
    select sinif, count(o.ogrno) as 'toplam' from ogrenci as o group by sinif
    order by toplam desc

27) Her sınıftaki erkek ve kız öğrenci sayısını bulunuz.
    select sinif,cinsiyet ,count(*) as 'ogrenci sayisi' from ogrenci group by sinif,cinsiyet
    order by sinif

            28) Her öğrencinin adını, soyadını ve okuduğu toplam sayfa sayısını büyükten küçüğe doğru listeleyiniz.
    select o.ograd ,o.ogrsoyad, sum(k.sayfasayisi) as total from ogrenci as o
    inner join islem as i on i.ogrno=o.ogrno
    inner join kitap as k on i.kitapno=k.kitapno
    group by o.ograd,o.ogrsoyad order by total desc

            29) Her öğrencinin okuduğu kitap sayısını getiriniz.
}
    select o.ogrno,o.ograd,o.ogrsoyad, count(kitapno) as 'kitap sayisi'
        from islem as i
        inner join ogrenci as o
        on i.ogrno=o.ogrno
        group by o.ogrno,ograd,o.ogrsoyad