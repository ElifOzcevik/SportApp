package com.example.elifozcevik.loginandregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME="Trainers"; //Tablo Adı
    private static final String DATABASE_NAME="Login";  //Veritabanı Adı
    private static final int DATABASE_VERSION=1;
    private static final String PERSONEL_KADI="PersonelAdı";
    private static final String PERSONEL_SOYAD="PersonelSoyad";
    private static final String COLUMN_USER_PASSWORD="password";
    private static final String TABLE_USER="user";
    private static final String COLUMN_USER_EMAIL="email";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(email text PRIMARY KEY, password text)");
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (id INTEGER PRIMARY KEY AUTOINCREMENT,"+PERSONEL_KADI+" TEXT,"+PERSONEL_SOYAD+" TEXT);");
        //db.execSQL("Create table trainers (id integer primary key autoincrement, name text, surname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE İF exists user");
       // db.execSQL("drop table if exists trainers");
        db.execSQL("DROP TABLE İF exists "+TABLE_NAME);
        this.onCreate(db);//onCreate fonksiyonu çağrılarak oluşturduğumuz veritabanı tablosunda güncelleme yaptık.
    }
    //inserting in database
    public boolean insert(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if (ins == -1) return false;
        else
            return true;

    }

    //Checking if email exists
    public boolean chkemail(String email) {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=?",new String[]{email});
        if (cursor.getCount()>0) return  false;
        else
            return true;
    }

    //checking the email and password
    public boolean chkemailpassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?", new String[]{email, password});
        if (cursor.getCount() > 0) return true;
        else
            return false;
    }


    public void veriEkle(String ad,String soyad){
        SQLiteDatabase db=this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        ContentValues cv=new ContentValues();//contentValues sınıfından bir nesne oluşturuyoruz.ContentValues değerleri tutmamızı sağlıyor.
        cv.put(PERSONEL_KADI,ad.trim());//Ad alıyoruz.
        cv.put(PERSONEL_SOYAD,soyad.trim());//Soyad alıyoruz.
        long r=db.insert(TABLE_NAME,null,cv);//Tabloya ekleme yaptığımız fonksiyon.
        if(r>-1)
            Log.i("tag","İşlem Başarılı");//ekleme olması durumunda bu çıktıyı verir.
        else
            Log.e("tag","İşlem Başarısız");//ekleme olmaması durumunda bu çıktıyı verir.
           db.close();//Veritabanı kapatma işlemi
    }
    public List<String> veriListele(){
        List<String> veriler=new ArrayList<String>();//String türünde bir liste oluşturduk.
        SQLiteDatabase db=this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        String[] sutunlar={PERSONEL_KADI,PERSONEL_SOYAD};
        Cursor cr=db.query(TABLE_NAME,sutunlar,null,null,null,null,null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.
        while(cr.moveToNext()){//sırasıyla verileri listelememizi sağlıyor.
            veriler.add(cr.getString(0)+"-"+cr.getString(1));

        }
        return veriler;
    }

    public void veriSil(String surname){
        SQLiteDatabase db=this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        db.delete(TABLE_NAME,PERSONEL_SOYAD + "=?",new String[]{String.valueOf(surname)});//personel adı girilerek veri silme işlemi yapıyoruz.
        db.close();//veritabanı kapatma işlemi
    }

    public List<String> list(){
        List<String> veriler=new ArrayList<String>();//String türünde bir liste oluşturduk.
        SQLiteDatabase db=this.getReadableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        String[] sutunlar={"email","password"};
        Cursor cr=db.query("user",sutunlar,null,null,null,null,null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.
        while(cr.moveToNext()){//sırasıyla verileri listelememizi sağlıyor.
            veriler.add(cr.getString(0)+"-"+cr.getString(1));

        }
        return veriler;
    }

    public void updatePassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_PASSWORD, password);
        db.update(TABLE_USER, values, COLUMN_USER_EMAIL+" = ?",new String[] { email });
        db.close();
    }


}
