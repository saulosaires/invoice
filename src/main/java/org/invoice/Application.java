package org.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
/*
  @Autowired
  private InvoiceFacade facade;

  @Autowired
  private CompanyRepository repository;

  @Autowired
  private ContactRepository contactRepository;

  @Autowired
  private BankRepository bankRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private StyleRepository styleRepository;

  @Autowired
  private InvoiceRepository invoiceRepository;


  @Autowired
  private ProductItemRepository productItemRepository;


  @Override
  public void run(String... args) throws Exception {

    Company c = repository.findAll().getFirst();
    Contact contact = contactRepository.findAll().getFirst();
    Bank bank = bankRepository.findAll().getFirst();
    Product product = productRepository.findAll().getFirst();
    User u = userRepository.findAll().getFirst();

    CompanyDto companyDto = new CompanyDto(c.getId(), null, null, null, null, null, null, null);
    ContactDto contactDto = new ContactDto(contact.getId(), null, null, null, null, null, null, null, true, true, null, null, null, null);
    BankDto bankDto = new BankDto(bank.getId(), null, null, null, null, null, null);

    ProductDto productDto = new ProductDto(product.getId(), null, null, null, null, null);

    ProductItemDto itemDto = new ProductItemDto(null, productDto, "ASSF", BigDecimal.ONE, BigDecimal.ZERO);

    StyleDto styleDto = new StyleDto(null, "roboto", 255, 255, 255);

    InvoiceDto invoiceDto = new InvoiceDto(null,
            companyDto,
            contactDto,
            "invoiceNumber",
            Instant.now(),
            Instant.now(),
            List.of(itemDto),
            InvoiceStatus.PAID.name(),
            "comment",
            bankDto,
            styleDto);


    productItemRepository.deleteAll();
    styleRepository.deleteAll();
    invoiceRepository.deleteAll();

    facade.save(u.getId(), invoiceDto);

  }
*/

}