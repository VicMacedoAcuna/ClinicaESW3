
document.getElementById("formulario").addEventListener("submit", function(event) {
    event.preventDefault();

    const nomeDono = document.getElementById("nomeDono").value;
    const enderecoDono = document.getElementById("enderecoDono").value;
    const telefoneDono = document.getElementById("telefoneDono").value;
    const tipoPet = document.getElementById("tipoPet").value;
    const nomePet = document.getElementById("nomePet").value;
    const pesoPet = document.getElementById("pesoPet").value;
    const racaPet = document.getElementById("racaPet").value;
    const nomeVet = document.getElementById("nomeVet").value;
    const dataConsulta = document.getElementById("dataConsulta").value;
    const medicamento = document.getElementById("medicamento").value;

    const resultado = document.getElementById("resultado");
    resultado.innerHTML = `
        <h2>Consulta Agendada</h2>
        <p><strong>Dono:</strong> ${nomeDono} (${telefoneDono})</p>
        <p><strong>Pet:</strong> ${nomePet} (${tipoPet}, ${racaPet}, ${pesoPet}kg)</p>
        <p><strong>Veterinário:</strong> ${nomeVet}</p>
        <p><strong>Data:</strong> ${dataConsulta}</p>
        <p><strong>Prescrição:</strong> ${medicamento}</p>
        <p><strong>Notificação:</strong> SMS enviado para ${telefoneDono}</p>
    `;
});
