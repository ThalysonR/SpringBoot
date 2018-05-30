package br.com.alura.listavip;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository repository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/listaconvidados")
    @Cacheable(value = "listaConvidados")
    public ModelAndView listaConvidados() {
        ModelAndView modelAndView = new ModelAndView("listaconvidados");
        Iterable<Convidado> convidados = repository.findAll();
        modelAndView.addObject("convidados", convidados);

        return modelAndView;
    }

    @RequestMapping("/criar")
    @ResponseBody
    public String criar() {
        Convidado convidado = new Convidado();
        convidado.setEmail("teste@teste.com");
        convidado.setNome("Teste");
        convidado.setTelefone("9999-9999");
        repository.save(convidado);

        return "Convidado Salvo.";
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public ModelAndView salvar(Convidado convidado) {
        System.out.println(convidado);

        return listaConvidados();
    }
}
