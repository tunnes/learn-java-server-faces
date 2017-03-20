package beans;

import model.Pessoa;;
import java.util.List;
import javax.inject.Named;
import java.util.ArrayList;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author tunnes
 * 
 * Escopo CDI
 *
 * Escopos CDI (Context and Dependency Injection) são mais utilizados pois possuem
 * injeção type safe, injeção automática, possuem métodos produtores e interceptadores.
 * os escopos mais pupulares e a utilizações de suas notações são os seguintes:
 * 
 *   @SessionScoped
 *   Anotamos quando o "Bean" vive enquanto a sessão HTTP durar (varios ciclos HTTP request e responses)
 *   a primeira requisição inicia a sessão e armazena os objetos que podem ser acessados pelas requições
 *   seguintes, uma sessão só termina quando o browser é fechado ou um timeout ocorre. 
 *    - No exemplo abaixo se for alterado o escopo para "SessionScoped" a lista de pessoas sera mantida 
 *      atravéz de várias requisiçoes.
 *    - Para utilizar este escopo é necessario implementar a interface "java.io.Serealizable".
 *   
 *   @ViewScoped
 *   Anotamos o bean quando queremos que ele viva enquanto o usuário estiver navegando view do JSF (Janela ou Aba)
 *   do browser, o bean é criado na primeira requisições à página e é destruído quando você vai para uma view diferente.   
 *     - Caso o atributo "action" de um "commandButton" ou "commandLink" for refência a uma página ou método.
 *       que não retorne null, a view muda isto acontece mesmo que você continue na mesma página.
 *     - Para sua utilização deve se implementar a interface "java.io.Serealizable".
 * 
 *   @ApplicationScoped
 *   Neste escopo o "Bean" vive enquanto a aplicação estiver rodando ele estende o escopo de sessão a todas as interações
 *   do usuário com a aplicação, um exemplo disto seria contar quantos usuários estão online e compartilhar essa informação 
 *   com todos eles.
 *     - Para testar este escopo abra vários browsers diferentes ou utilize multiplas máquinas.
 *     - Deve-se tomar cuidado pois com este escopo é possivel que os beans sejam alterados por cada sessão separadamente.
 *
 *   @ConversationScoped
 *   Esta anotação permite ao desenvolvedor especificar o tempo de vida de um escopo de sessão, é possivel definir os limites
 *   do escopo do "Bean", finalizando ou propagando o escopo baseando-se na lógica da aplicação desenvolvida.
 *     - Para sua utilização deve-se implementar a interface "java.io.Serealizable".
 *     - O "CDI" provê um bean para controlar o ciclo de vida de uma conversasão "javax.enterprise.context.Conversation".
 *     - Este Bean é obtido atravéz de injeção: "private @Inject Conversation conversation".
 *     - Por default este objeto está no estado transitório e deve iniciar uma conversação após a chamada ao método "begin",
 *       e para se encerrar uma conversação, deve ser chamado o método "end" exemplo abaixo:
 *       
 *       Iniciando -------------------------------------------------------------
 *       public void iniciarConversacao() {
 *          if (conversation.isTransient())
 *              conversation.begin();
 *       }
 *       Finalizando -----------------------------------------------------------
 *       public void encerrarConversacao() {
 *          if (!conversation.isTransient())
 *              conversation.end();
 *       }
 *       -----------------------------------------------------------------------
 * 
 *   @FlowScoped
 *   Esta notação permite agrupar páginas e demarcar o grupo com pontos de entrada e saída, o escopo do "Bean" se inicia
 *   na página de entrada e se encerra na página de saida da aplicação. Esta notação é muito utilizada em aplicações com 
 *   cadastro de múltiplas páginas, reservas de compras.
 * 
 *   @Dependent
 *   Este é o escopo default do "CDI" quando nenhum outro é espeficicado, ele faz com que o ciclo de vida do "Bean" seja
 *   o mesmo do "Bean" onde ele foi injetado.
 */




@Named(value = "pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable{

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas = new ArrayList<>();

    public PessoaBean() {
    }

    public String novaPessoa() {
        pessoas.add(pessoa);
        pessoa = new Pessoa();
        return null;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
