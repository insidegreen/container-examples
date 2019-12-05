Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/bionic64"
#  config.vm.box_version = "20181210.01"
  config.ssh.forward_agent = true
  config.vagrant.plugins = [ "vagrant-vbguest", "vagrant-proxyconf" ]

  if Vagrant.has_plugin?("vagrant-proxyconf")
    config.proxy.http     = "http://frcvdb002.conti.de:3128"
    config.proxy.https    = "http://frcvdb002.conti.de:3128"
    config.proxy.no_proxy = "localhost,127.0.0.1,.conti.de"
  end

  config.vm.network "forwarded_port", guest: 8080, host: 8080
  config.vm.network "forwarded_port", guest: 8443, host: 8443

  config.vm.synced_folder "./", "/vagrant"

  config.vm.provider "virtualbox" do |vb|
    vb.gui = true
    vb.customize ["modifyvm", :id, "--monitorcount", "1"]
    vb.memory = "8196"
    vb.cpus = 2
  end

  config.vm.provision "ansible_local" do |ansible|
    ansible.become = true
    ansible.config_file = "/vagrant/ansible/ansible.cfg"
    ansible.playbook = "/vagrant/ansible/playbooks/provision.yml"
    ansible.tags = "docker"
    #ansible.tags = "docker,desktop"
    ansible.galaxy_role_file = "/vagrant/ansible/requirements.yml"
    ansible.galaxy_roles_path = "/etc/ansible/roles"
    ansible.galaxy_command = "sudo ansible-galaxy install --role-file=%{role_file} --roles-path=%{roles_path} --force"
    ansible.extra_vars = {
      proxy_env: {},
      maven_version: "3.6.0",
      intellij_version: "2018.3",
      intellij_edition: "ultimate"
   }
  end

end
