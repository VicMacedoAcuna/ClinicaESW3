import adapter.*;
import builder.PetBuilder;
import facade.ClinicaFacade;
import model.*;
import singleton.VeterinarioImpl;
 
public class Teste {
 
    public static void executarConsulta(
        String nomeDono,
        String enderecoDono,
        String telefoneDono,
        String tipoPet,
        String nomePet,
        double pesoPet,
        String racaPet,
        String nomeVet,
        String dataConsulta,
        String[] medicamentos
    ) {
        ClinicaFacade facade = new ClinicaFacade();
 
        Dono dono = new Dono(nomeDono, enderecoDono, telefoneDono);
 
        Pet pet = new PetBuilder()
                .setTipo(tipoPet)
                .setNome(nomePet)
                .setPeso(pesoPet)
                .setRaca(racaPet)
                .build();
 
        VeterinarioImpl veterinario = VeterinarioImpl.getInstancia(nomeVet);
 
        Agendamento agendamento = facade.agendarConsulta(pet, veterinario, dataConsulta);
        agendamento.agendarConsulta();
        agendamento.realizarConsulta();
 
        Prescricao prescricao = facade.prescrever(pet, dono, medicamentos[0]);
        for (int i = 1; i < medicamentos.length; i++) {
            prescricao.adicionarMedicamento(medicamentos[i]);
        }
 
        prescricao.exibirPrescricao();
 
        NotificacaoExterna smsAdapter = new SMSAdapter(new ServicoSMS(), telefoneDono);
        smsAdapter.enviarMensagem("Consulta e prescrição finalizadas para o pet " + nomePet);
    }
}