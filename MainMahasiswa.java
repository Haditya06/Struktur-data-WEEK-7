
class Mahasiswa {

    private String nim;
    private String name;
    private String prodi;
    private String keperluan;

    public Mahasiswa(String nim, String name, String prodi, String keperluan) {
        this.nim = nim;
        this.name = name;
        this.prodi = prodi;
        this.keperluan = keperluan;
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public String getProdi() {
        return prodi;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void display() {
        System.out.println(nim + " | " + name + " | " + prodi + " | " + keperluan);
    }
}

class NodeMahasiswa {

    Mahasiswa data;
    NodeMahasiswa next;

    public NodeMahasiswa(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }

}

class QueueMahasiswa {

    private NodeMahasiswa front;
    private NodeMahasiswa rear;
    private int count;

    public QueueMahasiswa() {
        front = null;
        rear = null;
        count = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return count;
    }

    public void enqueue(Mahasiswa mhs) {
        NodeMahasiswa nn = new NodeMahasiswa(mhs);
        if (isEmpty()) {
            front = nn;
            rear = nn;
        } else {
            rear.next = nn;
            rear = nn;
        }
        count++;
    }

    public Mahasiswa dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Antrean kosong");
        }
        Mahasiswa mhs = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        count--;
        return mhs;
    }

    public Mahasiswa peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Antrean kosong");
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Anteran Kosong");
            return;
        }
        NodeMahasiswa current = front;
        System.out.println("DAFTAR ANTERAN MAHASISWA");
        while (current != null) {
            current.data.display();
            current = current.next;
        }
    }
}

public class MainMahasiswa {
    public static void main(String[] args) {
        QueueMahasiswa q = new QueueMahasiswa();
        q.enqueue(new Mahasiswa("1080825001", "Felix", "Bisnis Digital", "Legalisir"));
        q.enqueue(new Mahasiswa("1080825002", "Faiz", "Sistem Informasi", "SSC"));
        q.enqueue(new Mahasiswa("1080825003", "Ray", "Rekayasa Perangkat Lunak", "Picthing"));
        q.enqueue(new Mahasiswa("1080825004", "Dit", "Informatika", "KRTI"));
        System.out.println("Anteran Awal: ");
        q.display();
        System.out.println("\nMahasiswa dipanggil: ");
        Mahasiswa mhs = q.dequeue();
        mhs.display();
        System.out.println("\nSisa anteran");
        q.display();
        System.out.println("\nAnteran berikutnya");
        q.peek().display();
    }

}
