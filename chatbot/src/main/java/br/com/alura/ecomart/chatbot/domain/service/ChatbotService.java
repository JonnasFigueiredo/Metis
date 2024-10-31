package br.com.alura.ecomart.chatbot.domain.service;

import br.com.alura.ecomart.chatbot.infra.openai.DadosRequisicaoChatCompletion;
import br.com.alura.ecomart.chatbot.infra.openai.OpenAIClient;
import com.theokanning.openai.completion.chat.ChatCompletionChunk;
import io.reactivex.Flowable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatbotService {

    private OpenAIClient client;
    public ChatbotService(OpenAIClient client) {
        this.client = client;
    }

    public String responderPergunta(String pergunta) {
        var promptSistema = "Você é uma chatbot chamada Eva, você é técnica em segurança no trabalho e responderá perguntas relacionadas a isso";
        var dados = new DadosRequisicaoChatCompletion(promptSistema, pergunta);
        return client.enviarRequisicaoChatCompletion(dados);
    }

    public List<String> carregarHistorico () {
        return client.carregarHistoricoDeMensagens();
    }

    public void limparHistorico() {
        client.apagarThread();
    }
}
