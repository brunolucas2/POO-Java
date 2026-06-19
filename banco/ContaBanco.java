package banco;

public class ContaBanco {
    public    int     numConta;
    protected String  tipo;
    private   String  dono;
    private   float   saldo;
    private   boolean status;


    // Constructor ->
    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    //metodo de status ->
    public void EstadoAtual() {
        System.out.println();
        System.out.println("Conta Aberta com sucesso!");
        System.out.println("-----------------------------");
        System.out.println("Conta  : " + this.getNumConta());
        System.out.printf("Tipo   : %S%n", this.getTipo());
        System.out.printf("Dono   : %s%n", this.getDono());
        System.out.printf("Saldo  : %.2f%n", this.getSaldo());
        System.out.printf("Status : %B%n", this.getStatus());
        System.out.println("-----------------------------");

    }

    //Acessores e modificadores ->
    public int getNumConta () { return this.numConta; }
    public void setNumConta (int numConta) { this.numConta = numConta;}

    public String getTipo () { return this.tipo; }
    public void setTipo (String tipo) { this.tipo = tipo;}

    public String getDono () { return this.dono; }
    public void setDono (String dono) { this.dono = dono; }

    public float getSaldo () { return this.saldo; }
    public void setSaldo (float saldo) { this.saldo = saldo; }

    public boolean getStatus () { return this.status; }
    public void setStatus (boolean status) { this.status = status; }


    // Metodos ->
    public void abrirConta(String tipo) {
        if (this.getStatus()) {
            System.out.println("Não é possível abrir — já existe uma conta aberta");
            return;
        }

        this.setStatus(true);
        this.setTipo(tipo);

        switch(tipo) {
            case "CC" -> {
                    this.setSaldo(this.getSaldo() + 50f);
            }
            case "CP" -> {
                this.setSaldo(this.getSaldo() + 150f);
            }
        }

    }

    public void fecharConta() {
        if (this.getSaldo() < 0 ) {
            System.out.println("Conta não pode ser fechada pois tem debito");
        } else if (this.getSaldo() > 0){
            System.out.println("Conta não pode ser fechada porque ainda tem dinheiro");
        } else {
            System.out.println("Conta fechada com sucesso!");
            this.setStatus(false);
        }
    }

    public void depositar(float deposito) {
        if (this.getStatus()) {
            this.setSaldo(getSaldo() + deposito);
            System.out.println("Depósito realizado na conta de: " + this.getDono());
        } else {
            System.out.println("Impossível depositar em uma conta fechada!");
        }
    }

    public void sacar(float saque) {
        if (this.getStatus() && this.getSaldo() > 0) {
            if (this.getSaldo() < saque) {
                 System.out.println("Saldo insuficiente para sacar");
            } else {
                this.setSaldo(this.getSaldo() - saque);
                System.out.println("Saque realizado na conta: " + this.getDono());
            }
        } else {
            System.out.println("Impossível sacar");
        }
    }

    public void pagarMensal() {
        if (!this.getStatus()) {
            System.out.println("Conta fechada, não é possível cobrar mensalidade");
            return;
        }

        switch (this.getTipo()) {
            case "cc" -> {
                this.setSaldo(this.getSaldo() - 12f);
                System.out.printf("Mensalidade de R$ 12.00 cobrada%nSaldo atual: %.2f%n", this.getSaldo());
            }
            case "cp" -> {
                this.setSaldo(this.getSaldo() - 20f);
                System.out.printf("Mensalidade de R$ 20.00 cobrada%nSaldo atual: %.2f%n", this.getSaldo());
            }
        }
    }
}
// conta corrente 50 | conta poupança 150
