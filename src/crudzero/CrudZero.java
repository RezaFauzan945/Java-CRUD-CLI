package crudzero;
import java.util.Scanner;
public class CrudZero {
    
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    CrudHandler crud = new CrudHandler();
    
    int menu;
    
    System.out.println("=============");
    System.out.println("==CRUDZERO*==");
    System.out.println("=============");
    System.out.println("Masukan Angka");
    System.out.println("Untuk Memilih");
    System.out.println("=============");
    System.out.println("1.CREATE DATA");
    System.out.println("2.READ DATA");
    System.out.println("3.UPDATE DATA");
    System.out.println("4.DELETE DATA");
    System.out.println("=============");
    menu=Integer.parseInt(input.nextLine());
    switch(menu)
        {
            case 1 -> {
                int pilJk = 0;
                boolean status = true;
                String nis;
                String nama;
                String jenis_kelamin= "Belum Pilih";
                System.out.println("*CREATE ZERO SYSTEM*");
                System.out.println("Silahkan Masukan Nis Anda");
                nis=input.nextLine();
                System.out.println("Silahkan Masukan Nama Anda");
                nama=input.nextLine();   
                do{
                    System.out.println("Pilih Gender Anda (Pilih 1 untuk laki-laki ,pilih 2 untuk perempuan)");
                    pilJk=input.nextInt();
                    switch(pilJk)
                    {
                        case 1 -> {
                            jenis_kelamin="Laki-Laki";
                            status =false;
                        }
                        case 2 -> {
                            jenis_kelamin="Perempuan";
                            status = false;
                        }
                        default -> System.out.println("Hanya 1 Atau 2");
                    }
                }while(status);
                crud.CREATE(nis,nama,jenis_kelamin);
            }
            
            case 2 -> {
                crud.READ();
            }
            case 3 -> {
                int pilJk = 0;
                boolean status = true;
                String jenis_kelamin= "Belum Pilih";
                
                System.out.print("Berikut Data Yang Bisa Diubah Silahkan Ikuti Langkahnya");
                crud.READ();
                System.out.print("Masukan ID Data Yang Ingin Anda Rubah: ");
                int id = Integer.parseInt(input.nextLine());
                crud.READById(id);
                System.out.print("Masukan NIS Baru: ");
                String nis = input.nextLine().trim();
                System.out.print("Masukan NAMA Baru: ");
                String nama = input.nextLine().trim();
                do{
                    System.out.println("Pilih Gender Anda (Pilih 1 untuk laki-laki ,pilih 2 untuk perempuan)");
                    pilJk=input.nextInt();
                    switch(pilJk)
                    {
                        case 1 -> {
                            jenis_kelamin="Laki-Laki";
                            status =false;
                        }
                        case 2 -> {
                            jenis_kelamin="Perempuan";
                            status = false;
                        }
                        default -> System.out.println("Hanya 1 Atau 2");
                    }
                }while(status);
                
                crud.UPDATE(id,nis,nama,jenis_kelamin);
            }
            case 4 -> {
                crud.READ();
                System.out.print("Silahkan Masukan ID Data Yang akan Dihapus :");
                int id = Integer.parseInt(input.nextLine());
                crud.READById(id);
                System.out.println("Apa Anda Yakin Akan Menghapus Data Diatas? (y/n)");
                String confirm = input.nextLine();
                if("y".equals(confirm) || "Y".equals(confirm))
                {
                crud.DELETE(id);
                }else
                {
                    System.out.println("Anda Keluar Dari Program");
                }
            }
            default -> {
                System.out.println("Menu Yang Anda Pilih Salah , Hanya 1~4");
                System.out.println("Anda Keluar Dari Program");
            }
        }
    }
}
