<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="modal fade" id="update-customer-modal" tabindex="-1" role="dialog" aria-labelledby="update-customer-modal-label" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <span class="modal-title lead" id="update-customer-modal-label">Update customer information</span>
        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>

      <form action="saveCustomer" method="POST" name="updateCustomerForm">
        <div class="modal-body">
          <div class="container-fluid">
            <div class="row justify-content-center">
              <div class="col-md-10">
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="first-name" name="firstName" placeholder=".." value="populate first name here" required>
                  <label for="first-name" class="col-form-label">First name</label>
                </div>
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="last-name" name="lastName" placeholder=".." value="populate last name here" required>
                  <label for="last-name" class="col-form-label">Last name</label>
                </div>
                <div class="input-group mt-3">
                  <div class="form-floating">
                    <input type="text" class="form-control" id="email" name="username" placeholder="Username.." value="populate username here" required>
                    <label for="email">Username</label>
                  </div>
                  <label class="input-group-text">@</label>
                  <div class="form-floating">
                    <input type="text" class="form-control" id="domain" name="domain" placeholder="Domain.." value="populate domain here" required>
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
          <button id="editCustomerBtn" type="submit" class="btn btn-success">Save changes</button>
        </div>

        <input id="id-input" type="hidden" name="id"/>
      </form>
    </div>
  </div>
</div>