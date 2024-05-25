import java.util.Scanner;

public class SweetFlight {
    static class Reserva {
        int aviao;
        String passageiros;
    } 

    static int[] aviao = new int[4];
    static int[] sit = new int[4];
    static Reserva[] checkin = new Reserva[20];

    static int a = 0, b = 5, c = 10, d = 15;

    static Scanner scanner = new Scanner(System.in);

    static void registrarAviao() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Digite o número do " + (i + 1) + " avião");
            aviao[i] = scanner.nextInt();
        }
    }

    static void registrarAssento() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Digite a quantidade de assentos do avião " + aviao[i]);
            sit[i] = scanner.nextInt();
        }
    }

    static void fazerReserva() {
        System.out.println("Informe o número do avião");
        int nVoo = scanner.nextInt();

        if (nVoo == aviao[0] && a <= sit[0]) {
            System.out.println("Informe o nome do passageiro");
            checkin[a] = new Reserva();
            checkin[a].passageiros = scanner.next();
            checkin[a].aviao = nVoo;
            sit[0]--;
            a++;
        } else if (nVoo == aviao[1] && b <= sit[1] + 5) {
            System.out.println("Informe o nome do passageiro");
            checkin[b] = new Reserva();
            checkin[b].passageiros = scanner.next();
            checkin[b].aviao = nVoo;
            sit[1]--;
            b++;
        } else if (nVoo == aviao[2] && c <= sit[2] + 10) {
            System.out.println("Informe o nome do passageiro");
            checkin[c] = new Reserva();
            checkin[c].passageiros = scanner.next();
            checkin[c].aviao = nVoo;
            sit[2]--;
            c++;
        } else if (nVoo == aviao[3] && d <= sit[3] + 15) {
            System.out.println("Informe o nome do passageiro");
            checkin[d] = new Reserva();
            checkin[d].passageiros = scanner.next();
            checkin[d].aviao = nVoo;
            sit[3]--;
            d++;
        } else {
            System.out.println("Este avião não existe! Ou está lotado!");
        }
    }

    static void consultaAviao() {
        System.out.println("Informe o número do avião");
        int numAviao = scanner.nextInt();
        System.out.println("RESERVAS");
        if (numAviao == aviao[0]) {
            boolean reservasVazias = true;
            for (int i = 0; i < 5; i++) {
                if (!checkin[i].passageiros.equals("")) {
                    reservasVazias = false;
                    System.out.println("Nome: " + checkin[i].passageiros);
                }
            }
            if (reservasVazias) {
                System.out.println("Não há reservas realizadas para este avião!");
            }
        } else if (numAviao == aviao[1]) {
            boolean reservasVazias = true;
            for (int i = 5; i < 10; i++) {
                if (!checkin[i].passageiros.equals("")) {
                    reservasVazias = false;
                    System.out.println("Nome: " + checkin[i].passageiros);
                }
            }
            if (reservasVazias) {
                System.out.println("Não há reservas realizadas para este avião!");
            }
        } else if (numAviao == aviao[2]) {
            boolean reservasVazias = true;
            for (int i = 10; i < 15; i++) {
                if (!checkin[i].passageiros.equals("")) {
                    reservasVazias = false;
                    System.out.println("Nome: " + checkin[i].passageiros);
                }
            }
            if (reservasVazias) {
                System.out.println("Não há reservas realizadas para este avião!");
            }
        } else if (numAviao == aviao[3]) {
            boolean reservasVazias = true;
            for (int i = 15; i < 20; i++) {
                if (!checkin[i].passageiros.equals("")) {
                    reservasVazias = false;
                    System.out.println("Nome: " + checkin[i].passageiros);
                }
            }
            if (reservasVazias) {
                System.out.println("Não há reservas realizadas para este avião!");
            }
        } else {
            System.out.println("Este avião não existe!");
        }
    }

    static void consultaPassageiros() {
        System.out.println("Informe o nome do passageiro");
        String nome = scanner.next();
        System.out.println("~~~~~");
        System.out.println("Reservas de Clientes");
        System.out.println("~~~~~");
        for (int i = 0; i < 20; i++) {
            if (!checkin[i].passageiros.equals("")) {
                if (nome.equals(checkin[i].passageiros)) {
                    System.out.println("Nome: " + checkin[i].passageiros + "| Avião: " + checkin[i].aviao);
                    return;
                }
            }
        }
        System.out.println("Não há reservas realizadas para este passageiro!");
    }

    static void assentosDisponiveis() {
        int soma = sit[0] + sit[1] + sit[2] + sit[3];
        if (soma != 0) {
            System.out.println(soma + " Lugares disponíveis");
            for (int i = 0; i < 4; i++) {
                System.out.println("Voo" + aviao[i] + ": " + sit[i]);
            }
        }
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("MENU:");
            assentosDisponiveis();
            System.out.println("1: Registrar o número de cada avião.");
            System.out.println("2: Registrar assentos disponíveis em cada avião.");
            System.out.println("3: Reservar passagem aérea.");
            System.out.println("4: Realizar consulta por avião.");
            System.out.println("5: Realizar consulta por passageiro.");
            System.out.println("6: Encerrar.");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarAviao();
                    break;
                case 2:
                    registrarAssento();
                    break;
                case 3:
                    fazerReserva();
                    break;
                case 4:
                    consultaAviao();
                    break;
                case 5:
                    consultaPassageiros();
                    break;
            }
        } while (opcao != 6);
    }
}
