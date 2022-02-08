package crudzero;

import java.awt.HeadlessException;
import java.sql.*;


public class CrudHandler extends Koneksi
{
    Koneksi koneksi =new Koneksi();

    void CREATE(String nis, String nama, String jenis_kelamin)
    {
        String qCREATE = "INSERT INTO SISWA(nis,nama,jenis_kelamin) VALUES "+"("+nis+",'"+nama+"','"+jenis_kelamin+"')";
        try
        {
            System.out.println("Memproses Permintaan Mohon Tunggu!");
            Connection con = koneksi.konek();
            PreparedStatement pst = con.prepareStatement(qCREATE);
            pst.execute();
            System.out.println("Berhasil Ditambahkan");
        }
        catch(SQLException |HeadlessException e)
        {
            System.out.println(e);
        }
    }
    
    void READ()
    {
        String qREAD = "SELECT * FROM SISWA";
        Statement stm;
        try
        {
            System.out.println("Memproses Permintaan Mohon Tunggu!");
            Connection con = koneksi.konek();
            stm = con.createStatement();
            ResultSet result = stm.executeQuery(qREAD);
            System.out.println("Berikut Data Yang Ada Pada Table SISWA");
            while(result.next()){
                System.out.println("========================================================");
                System.out.println("ID:            |" + result.getString("id"));
                System.out.println("NIS:           |" + result.getString("nis"));
                System.out.println("NAMA:          |" + result.getString("nama"));
                System.out.println("Jenis Kelamin: |" + result.getString("jenis_kelamin"));
                System.out.println("========================================================");
            }
        }
        catch(SQLException |HeadlessException e)
        {
            System.out.println(e);
        }
    }
    
    void READById(int id)
    {
        String qREAD = "SELECT * FROM SISWA WHERE id='"+id+"'";
        Statement stm;
        try
        {
            System.out.println("Memproses Permintaan Mohon Tunggu!");
            Connection con = koneksi.konek();
            stm = con.createStatement();
            ResultSet result = stm.executeQuery(qREAD);
            System.out.println("Berikut Data Yang Ada Pada Table SISWA");
            while(result.next()){
                System.out.println("========================================================");
                System.out.println("ID:            |" + result.getString("id"));
                System.out.println("NIS:           |" + result.getString("nis"));
                System.out.println("NAMA:          |" + result.getString("nama"));
                System.out.println("Jenis Kelamin: |" + result.getString("jenis_kelamin"));
                System.out.println("========================================================");
            }
        }
        catch(SQLException |HeadlessException e)
        {
            System.out.println(e);
        }
    }
    
     void UPDATE(int id, String nis, String nama, String jenis_kelamin)
    {
        String qUPDATE = "UPDATE SISWA SET "+"nis='"+nis+"',nama='"+nama+"',jenis_kelamin='"+jenis_kelamin+"'WHERE id='"+id+"'";
        Statement stm ;
        try 
        {
            Connection con = koneksi.konek();
            stm = con.createStatement();
            stm.execute(qUPDATE);
            
            System.out.println("Memproses UPDATE");
            System.out.println("BERHASIL MENGUBAH DATA!");
        }
        catch (Exception e) 
        {
            System.out.println("Update Gagal Baca Pesan Error Berikut");
            e.printStackTrace();
        }
    }
     void DELETE(int id)
     {
        String qDELETE = String.format("DELETE FROM siswa WHERE id='" +id+ "'");
        Statement stm ;
        try
        {
            Connection con = koneksi.konek();
            stm = con.createStatement();
            stm.execute(qDELETE);
            System.out.println("DATA BERHASIL DIHAPUS!");
        }
        catch (Exception e) 
        {
            System.out.println("Proses DELETE Gagal Baca Pesan Error Berikut");
            e.printStackTrace();
        }
     }
    
}
