<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="modal fade" id="add-customer-modal" tabindex="-1" role="dialog" aria-labelledby="add-customer-modal-label" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <span class="modal-title lead" id="add-customer-modal-label">Add new customer</span>
        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>

      <form action="saveCustomer" method="POST">
      <div class="modal-body">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="first-name" name="firstName" placeholder=".." required>
                  <label for="first-name" class="col-form-label">First name</label>
                </div>
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="last-name" name="lastName" placeholder=".." required>
                  <label for="last-name" class="col-form-label">Last name</label>
                </div>
                <div class="input-group mt-3">
                  <div class="form-floating">
                    <input type="text" class="form-control" id="email" name="username" placeholder="Username.." required>
                    <label for="email">Username</label>
                  </div>
                  <label class="input-group-text">@</label>
                  <div class="form-floating">
                    <input type="text" class="form-control" id="domain" name="domain" placeholder="Domain.." required>
                    <label for="domain">Domain</label>
                  </div>
                  <label class="input-group-text">.com</label>
                </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
        <button id="addCustomerBtn" type="submit" class="btn btn-success">Add Customer</button>
      </div>
      </form>
    </div>
  </div>
</div>